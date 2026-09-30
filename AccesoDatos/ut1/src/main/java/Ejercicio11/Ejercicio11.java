package Ejercicio11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


public class Ejercicio11 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    List <Contacto> agenda = new ArrayList<>();
    String rutaArchivo = "./agenda.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    File archivo = new File(rutaArchivo);

    boolean salir = false;

    try{
        if(!archivo.exists()){
            archivo.createNewFile();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    if (archivo.length() > 0) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            Type tipoLista = new TypeToken<List<Contacto>>() {}.getType();
            List<Contacto> contactosCargados = gson.fromJson(br, tipoLista);
            if (contactosCargados != null) {
                agenda = new ArrayList<>(contactosCargados);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }      

    while (!salir) {
        System.out.println("\n--- AGENDA ---");
        System.out.println("1. Mostrar Lista de Contactos");
        System.out.println("2. Insertar nuevo contacto");
        System.out.println("3. Borrar contacto");
        System.out.println("4. Guardar cambios y salir");
        System.out.print("Opción: ");

        int opcion = input.nextInt();
        input.nextLine();

        switch (opcion) {
            case 1:
                if (agenda.isEmpty()) {
                    System.out.println("La agenda está vacía.");
                } else {
                    for (int i = 0; i < agenda.size(); i++) {
                        System.out.println((i+1) + ". " + agenda.get(i));
                    }
                }
                break;

            case 2:
                System.out.print("Nombre del Contacto: ");
                String name = input.nextLine();
                System.out.print("Teléfono: ");
                int number = input.nextInt();
                input.nextLine(); // Limpiar buffer

                agenda.add(new Contacto(number, name));
                System.out.println("Contacto añadido en memoria.");
                break;

            case 3:
                System.out.print("Nombre del contacto a borrar: ");
                String nombreBorrar = input.nextLine();
                int indexBorrar = 0;

                for(Contacto c : agenda){
                    if(c.getNombre().equalsIgnoreCase(nombreBorrar)){
                        indexBorrar = agenda.indexOf(c);
                        break;
                    }
                }

                if (agenda.size() > 0) {
                    agenda.remove(indexBorrar);
                    System.out.println("Contacto eliminado.");
                } else {
                    System.out.println("Indice no válido.");
                }
                break;

            case 4:
                try(BufferedWriter bw = new BufferedWriter(new FileWriter("./agenda.json"))){
                    gson.toJson(agenda, bw);
                    System.out.println("Agenda guardada con éxito!");
                    salir = true;
                    break;
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }               

            default:
                System.out.println("Opción no válida.");
                break;
            }
        }
        input.close();
    }
}
}


