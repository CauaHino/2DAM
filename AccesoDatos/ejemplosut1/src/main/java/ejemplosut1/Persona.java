package ejemplosut1;

import java.io.Serializable;

public class Persona implements Serializable{
    private String nombre;
    private int edad;

    public Persona (String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String toString(){
            return "PERSONA: \n"+
            "\tNombre: "+this.nombre+"\n"+
            "\tEdad: "+this.edad+"\n";   
        }
}