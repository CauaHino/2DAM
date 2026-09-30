package Ejercicio10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
    String archivo = "./mascota.bin";
        Scanner input = new Scanner(System.in);
        File file = new File(archivo);
        Mascota mascota = null;
        boolean salir = false;

        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                mascota = (Mascota) ois.readObject();
                mascota.iniciar();
            } catch (Exception e) {
                System.out.println("Error al cargar la agenda previa: " + e.getMessage());
            }
            while (!salir) {
                System.out.println("1. Consultar el estado de la mascota");
                System.out.println("2. Alimentar a la mascota");
                System.out.println("3. Descansar");
                System.out.println("4. Guardar y salir");
                int opcion = input.nextInt();
                input.nextLine();
                switch (opcion) {
                    case 1: 
                        System.out.println(mascota.toString());
                        break;
                    case 2:
                        mascota.alimentar();
                        System.out.println("La mascota fue alimentada con éxito");
                        break;
                    case 3:
                        mascota.descansar();
                        System.out.println("La mascota fue descansar");
                        break;
                    case 4:
                        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
                            oos.writeObject(mascota);
                            salir = true;
                        } catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    default:
                        System.out.println("Elije una de las 4 opciones");
                }
            }
        } else {
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
                mascota = new Mascota();
                oos.writeObject(mascota);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

