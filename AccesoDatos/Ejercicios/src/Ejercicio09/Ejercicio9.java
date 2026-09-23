package Ejercicio09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio9 {
        public static void main(String[] args) {
        String archivo = "./agenda.bin";
        Scanner input = new Scanner(System.in);
        ArrayList<Contacto> agenda = new ArrayList<>();
        File file = new File(archivo);

        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                agenda = (ArrayList<Contacto>) ois.readObject();
            } catch (Exception e) {
                System.out.println("Error al cargar la agenda previa: " + e.getMessage());
            }
        }

        boolean salir = false;

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
                            System.out.println(i + ". " + agenda.get(i));
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
                    System.out.print("Índice del contacto a borrar: ");
                    int index = input.nextInt();
                    input.nextLine();

                    if (index >= 0 && index < agenda.size()) {
                        agenda.remove(index);
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("Índice no válido.");
                    }
                    break;

                case 4:
                    // 2. Guardar toda la lista en disco antes de salir
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                        oos.writeObject(agenda);
                        System.out.println("Cambios guardados con éxito.");
                    } catch (Exception e) {
                        System.out.println("Error al guardar: " + e.getMessage());
                    }
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        input.close();
    }
}