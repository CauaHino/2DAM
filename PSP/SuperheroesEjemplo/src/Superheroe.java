import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Superheroe implements Callable<Integer> {
    private String nombre;
    private String tipo; // Ej: "Fuego"
    private int nivelExperiencia;
    private Fortaleza fortaleza;
    private BlockingQueue<Arma> mochila;

    public Superheroe(String nombre, String tipo, Fortaleza fortaleza, int capacidadMochila) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fortaleza = fortaleza;
        this.nivelExperiencia = 1;
        this.mochila = new ArrayBlockingQueue<>(capacidadMochila);
    }

    // Requisito: hacer conjuro antes de entrar a una sala
    public boolean hacerConjuro(Sala sala) throws InterruptedException {
        System.out.println( nombre + " (" + tipo + ") lanza un conjuro para abrir la sala " + sala.getNumero());
        Thread.sleep(100); // Tiempo de casteo del conjuro
        this.nivelExperiencia++; // Usar la mecánica de experiencia
        return true;
    }

    @Override
    public Integer call() throws Exception {
        while (!Thread.currentThread().isInterrupted() && mochila.remainingCapacity() > 0) {
            Sala sala = fortaleza.getSalaAleatoria();

            try {
                // 1. Hacer conjuro para entrar
                if (!hacerConjuro(sala)) continue;

                // 2. Entrar en la sala
                sala.entrar(this);
                try {
                    // 3. Comprobar monstruo
                    if (sala.isHayMonstruo()) {
                        Arma perdida = mochila.poll();
                        if (perdida != null) {
                            sala.dejarArma(perdida);
                            System.out.println("Monstruo roba " + perdida + " a " + nombre);
                        }
                    } else {
                        // 4. Si hay otros héroes en la sala, pelean
                        sala.gestionarEncuentro(this);

                        // 5. Intentar coger arma de su mismo tipo elemental
                        Arma arma = sala.cogerArmaPorTipo(this.tipo);
                        if (arma != null && mochila.offer(arma)) {
                            this.nivelExperiencia += 2;
                            System.out.println(nombre + " consigue " + arma + " (Nv." + nivelExperiencia + ")");
                        }
                    }
                    Thread.sleep(200);
                } finally {
                    // Pase lo que pase, el héroe abandona la sala al terminar el turno
                    sala.salir(this);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        return calcularValorMochila();
    }

    // Lógica de pelea entre dos héroes en la misma sala
    public void pelearCon(Superheroe rival, Sala sala) {
        Superheroe ganador = (this.nivelExperiencia >= rival.nivelExperiencia) ? this : rival;
        Superheroe perdedor = (ganador == this) ? rival : this;

        ganador.subirExperiencia(3);
        Arma botin = perdedor.perderArma(); // Saca un arma de la mochila concurrente del perdedor

        if (botin != null) {
            // Si el ganador es del mismo tipo que el arma, se la queda; si no, cae al suelo de la sala
            if (botin.getTipo().equalsIgnoreCase(ganador.tipo) && ganador.mochila.offer(botin)) {
                System.out.println("PELEA en sala " + sala.getNumero() + ": " + ganador.nombre
                        + " vence a " + perdedor.nombre + " y le roba " + botin);
            } else {
                sala.dejarArma(botin);
                System.out.println("PELEA en sala " + sala.getNumero() + ": " + ganador.nombre
                        + " vence a " + perdedor.nombre + " y " + botin + " cae a la sala");
            }
        }
    }

    public Arma perderArma() {
        return mochila.poll();
    }

    public void subirExperiencia(int puntos) {
        this.nivelExperiencia += puntos;
    }

    public int calcularValorMochila() {
        int total = 0;
        for (Arma a : mochila) {
            total += a.getPrecio();
        }
        return total;
    }
}