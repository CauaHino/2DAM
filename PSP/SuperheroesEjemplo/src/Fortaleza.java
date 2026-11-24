import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Fortaleza {
    private ArrayList<Sala> salas;
    private ArrayList<Arma> catalogoArmas;
    private Random random;

    public Fortaleza() {
        random = new Random();
        salas = new ArrayList<Sala>();
        catalogoArmas = new ArrayList<Arma>();

        // 1. Catálogo base de 10 armas con nombre, tipo elemental y precio
        catalogoArmas.add(new Arma("Espada Llameante", "Fuego", 150));
        catalogoArmas.add(new Arma("Escudo Ígneo", "Fuego", 120));
        catalogoArmas.add(new Arma("Lanza Solar", "Fuego", 180));
        catalogoArmas.add(new Arma("Tridente Abisal", "Agua", 160));
        catalogoArmas.add(new Arma("Capa de Marea", "Agua", 110));
        catalogoArmas.add(new Arma("Anillo Glacial", "Agua", 140));
        catalogoArmas.add(new Arma("Martillo Sísmico", "Tierra", 170));
        catalogoArmas.add(new Arma("Armadura de Roca", "Tierra", 190));
        catalogoArmas.add(new Arma("Arco del Vendaval", "Aire", 130));
        catalogoArmas.add(new Arma("Casco Alado", "Aire", 145));

        // 2. Lista temporal con las 10 armas base
        ArrayList<Arma> armasSalas = new ArrayList<Arma>();
        for (Arma arma : catalogoArmas) {
            armasSalas.add(new Arma(arma.getNombre(), arma.getTipo(), arma.getPrecio()));
        }

        // 3. Añadir otras 10 armas aleatorias del catálogo
        for (int i = 0; i < 10; i++) {
            int posicion = random.nextInt(catalogoArmas.size());
            Arma base = catalogoArmas.get(posicion);
            armasSalas.add(new Arma(base.getNombre(), base.getTipo(), base.getPrecio()));
        }

        // 4. Mezclar armas y crear las 20 salas
        Collections.shuffle(armasSalas);
        for (int i = 0; i < 20; i++) {
            Sala sala = new Sala(i + 1, armasSalas.get(i));
            salas.add(sala);
        }
    }

    public Sala getSalaAleatoria() {
        int posicion = random.nextInt(salas.size());
        return salas.get(posicion);
    }

    public Arma getArmaAleatoria() {
        int posicion = random.nextInt(catalogoArmas.size());
        Arma base = catalogoArmas.get(posicion);
        return new Arma(base.getNombre(), base.getTipo(), base.getPrecio());
    }

    public int getNumeroTrofeos() {
        return catalogoArmas.size();
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void mostrarSalas() {
        System.out.println("=== SALAS DE LA FORTALEZA ===");
        for (Sala sala : salas) {
            System.out.println("Sala " + sala.getNumero() + " | Monstruo: " + sala.isHayMonstruo());
        }
    }
}