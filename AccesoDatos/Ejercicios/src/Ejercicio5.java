import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Path path = Path.of("./blocs");
        String contenido;

        System.out.print("Introduzca el nombre del usuario: ");
        String nombre = input.nextLine();
        nombre = nombre.toUpperCase();
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(path.resolve("bloc_" + nombre + ".txt").toFile(), true))) {
                System.out.print("¿Que desea escribir en el archivo? ");
                contenido = input.nextLine();
                while (!contenido.equalsIgnoreCase("BYE")) {
                    bw.write(contenido+"\n");
                    System.out.print("¿Que desea escribir en el archivo? ");
                    contenido = input.nextLine();
                } 
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

}
