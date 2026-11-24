public class Monstruo implements Runnable {
    private Fortaleza fortaleza;
    private Sala salaActual;

    public Monstruo(Fortaleza fortaleza) {
        this.fortaleza = fortaleza;
        this.salaActual = fortaleza.getSalaAleatoria();
        this.salaActual.setHayMonstruo(true);
    }

    @Override
    public void run() {
        // 1. Abandona la sala donde estaba
        if (salaActual != null) {
            salaActual.setHayMonstruo(false);
        }
        // 2. Se mueve a una sala aleatoria nueva
        salaActual = fortaleza.getSalaAleatoria();
        salaActual.setHayMonstruo(true);
        System.out.println("[DEMONIO] El monstruo se ha movido a la sala " + salaActual.getNumero());
    }
}