import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Juego {
    public static void main(String[] args) {
        // 1. Creamos la fortaleza con 20 salas y armas de varios tipos y precios
        Fortaleza fortaleza = new Fortaleza();
        fortaleza.mostrarSalas();

        // 2. Definimos los héroes y su tipo elemental (solo pueden coger armas de su
        // tipo)
        String[] nombres = { "Iron Man", "Thor", "Hulk", "Batman", "Superman" };
        String[] tipos = { "Fuego", "Aire", "Tierra", "Fuego", "Agua" };

        // 3. Hilo DEMONIO con ScheduledExecutorService para el Monstruo y reposición
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread hiloDemonio = new Thread(r, "Hilo-Demonio-Monstruo");
                hiloDemonio.setDaemon(true); // Lo marcamos como demonio antes de devolverlo
                return hiloDemonio;
            }
        });
        // Se ejecuta nada más empezar (0s) y se repite cada 2 segundos
        scheduler.scheduleAtFixedRate(new Monstruo(fortaleza), 0, 2, TimeUnit.SECONDS);

        // 4. ExecutorService fijo para lanzar los 5 héroes a la vez
        ExecutorService executorHeroes = Executors.newFixedThreadPool(nombres.length);
        List<Future<Integer>> futuros = new ArrayList<>();

        System.out.println("\n¡COMIENZA LA AVENTURA EN LA FORTALEZA!\n");

        for (int i = 0; i < nombres.length; i++) {
            // Cada héroe tiene una mochila con capacidad para 3 armas
            Superheroe heroe = new Superheroe(nombres[i], tipos[i], fortaleza, 3);
            Future<Integer> futuro = executorHeroes.submit(heroe);
            futuros.add(futuro);
        }

        // 5. Esperar a que todos terminen y recoger el valor de sus mochilas (Callable
        // + Future)
        int oroTotalFortaleza = 0;
        String mejorHeroe = "";
        int maxOro = -1;

        for (int i = 0; i < futuros.size(); i++) {
            try {
                int oroHeroe = futuros.get(i).get(); // Bloquea hasta que este héroe termine
                System.out.println(
                        nombres[i] + " (" + tipos[i] + ") terminó con armas valoradas en: " + oroHeroe + " de oro.");

                oroTotalFortaleza += oroHeroe;
                if (oroHeroe > maxOro) {
                    maxOro = oroHeroe;
                    mejorHeroe = nombres[i];
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // 6. Apagado limpio de los ejecutores (imprescindible para que la JVM cierre)
        executorHeroes.shutdown();
        scheduler.shutdownNow();

        System.out.println("\n==========================================");
        System.out.println("GANADOR: " + mejorHeroe + " con " + maxOro + " de oro.");
        System.out.println("Botín total entre todos los héroes: " + oroTotalFortaleza + " de oro.");
        System.out.println("==========================================");
    }
}