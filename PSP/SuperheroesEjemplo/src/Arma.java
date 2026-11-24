public class Arma {
    private String nombre;
    private String tipo;   // Ej: "Fuego", "Agua", "Tierra", "Aire"
    private int precio;

    public Arma(String nombre, String tipo, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getPrecio() { return precio; }

    @Override
    public String toString() {
        return nombre + " [" + tipo + " - " + precio + " oro]";
    }
}