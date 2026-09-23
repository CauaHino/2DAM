import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Path path;

        System.out.println("Introduce el nombre o la palabra que desea buscar: ");
        String palabra = input.nextLine();
        System.out.println("Introduce la ruta absoluta del fichero: ");
        path = Path.of(input.nextLine());

        try(BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String linea;
            int contadorLineas = 0;
            int contadorPalabras = 0;
            int coincidenciasTotales = 0;
            while((linea = br.readLine()) != null) {
                contadorLineas++;
                contadorPalabras = 0;
                for (String palabraLinea : linea.split(" ")) {
                    if (palabraLinea.equalsIgnoreCase(palabra)) {
                        contadorPalabras++;
                    }
                }
                coincidenciasTotales += contadorPalabras;
                if (contadorPalabras > 0) {
                    System.out.println("Línea " + contadorLineas + " -> " + contadorPalabras + " coincidencias");
                }
            }
            System.out.println("Total de coincidencias: " + coincidenciasTotales);
        } catch (IOException e) {
            e.printStackTrace();

        }
        
    }
}
