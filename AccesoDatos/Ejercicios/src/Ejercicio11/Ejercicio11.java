
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Ejercicio11 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    List <Contacto> agenda = new ArrayList<>();
    String rutaArchivo = "./agenda.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    boolean salir = false;

    try{
        if(!Files.isRegularFile(Path.of(rutaArchivo))){
            Files.createFile(Path.of(rutaArchivo));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
        if(br.read() != -1){
            agenda = Arrays.asList(gson.fromJson(br, Contacto[].class));
        }          
        
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
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
        input.nextLine(); // Limpiar el buffer de salto de línea

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
                System.out.print("Indice del contacto a borrar: ");
                int index = input.nextInt() - 1;
                input.nextLine();

                if (index >= 0 && index < agenda.size()) {
                    agenda.remove(index);
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


