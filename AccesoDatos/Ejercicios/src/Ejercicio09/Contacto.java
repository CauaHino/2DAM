package Ejercicio09;

import java.io.Serializable;

public class Contacto implements Serializable {
    private int telefono;
    private String nombre;

    public Contacto(int telefono, String nombre) {
        this.telefono = telefono;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Teléfono: " + telefono;
    }
}