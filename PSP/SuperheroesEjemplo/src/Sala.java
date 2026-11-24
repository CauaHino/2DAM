import java.util.concurrent.ConcurrentLinkedQueue;

public class Sala {
    private int numero;
    private ConcurrentLinkedQueue<Arma> armas;
    private ConcurrentLinkedQueue<Superheroe> ocupantes;
    private volatile boolean hayMonstruo;

    public Sala(int numero, Arma armaInicial) {
        this.numero = numero;
        this.armas = new ConcurrentLinkedQueue<>();
        this.ocupantes = new ConcurrentLinkedQueue<>();
        if (armaInicial != null) {
            this.armas.add(armaInicial);
        }
        this.hayMonstruo = false;
    }

    public void entrar(Superheroe heroe) {
        ocupantes.add(heroe);
    }

    public void salir(Superheroe heroe) {
        ocupantes.remove(heroe);
    }

    // Sincronizado sobre ESTA sala: si hay 2+ héroes, pelean sin interferencias
    public synchronized void gestionarEncuentro(Superheroe visitante) {
        if (ocupantes.size() >= 2) {
            for (Superheroe rival : ocupantes) {
                if (!rival.equals(visitante)) {
                    visitante.pelearCon(rival, this);
                    break; // Pelea con un rival presente en la sala
                }
            }
        }
    }

    // Solo coge un arma si coincide con el tipo elemental del héroe
    public Arma cogerArmaPorTipo(String tipoHeroe) {
        for (Arma arma : armas) {
            if (arma.getTipo().equalsIgnoreCase(tipoHeroe)) {
                if (armas.remove(arma)) { // remove() es atómico en ConcurrentLinkedQueue
                    return arma;
                }
            }
        }
        return null;
    }

    public void dejarArma(Arma arma) {
        if (arma != null) {
            armas.add(arma);
        }
    }

    public int getNumero() { return numero; }
    public boolean isHayMonstruo() { return hayMonstruo; }
    public void setHayMonstruo(boolean hayMonstruo) { this.hayMonstruo = hayMonstruo; }
}