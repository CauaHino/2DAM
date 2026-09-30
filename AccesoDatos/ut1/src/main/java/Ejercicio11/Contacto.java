package Ejercicio11;

public class Contacto {
    private int telefono;
    private String nombre;

    public Contacto(int telefono, String nombre) {
        this.telefono = telefono;
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getTelefono(){
        return this.telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Teléfono: " + telefono;
    }

}
