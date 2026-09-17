import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio2 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("============== APARTADO A ==============");
        
            Path ruta1 = Path.of("./empresa/nominas/2025_26");
            Path ruta2 = Path.of("./empresa/nominas/2026_27");
            Path ruta3 = Path.of("./empresa/imagenes");
        
        try {
            if (Files.notExists(ruta1)){
            Files.createDirectories(ruta1);
            }
            if (Files.notExists(ruta2)){
            Files.createDirectories(ruta2);
            }
            if (Files.notExists(ruta3)){
            Files.createDirectories(ruta3);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("============== APARTADO B ==============");
        while (true) {
            System.out.print("Nombre del archivo: ");
            String nombreArchivo = input.nextLine();
            if (nombreArchivo.equals("salir")) {
                break;
            }
            Path ruta21 = Path.of("./empresa/nominas/2026_27/" + nombreArchivo);
            Files.createFile(ruta21);
        }

         System.out.println("============== APARTADO C ==============");
         Path [] rutas = {Path.of("./empresa/nominas/2025_26"), Path.of("./empresa/imagenes"), 
                            Path.of("./empresa/nominas/2025_26"), Path.of("./empresa/nominas/2026_27/febrero.pdf"),
                            Path.of("./empresa/nominas/2026_27/nomina_enero.pdf")};
         for (Path ruta : rutas) {
             System.out.println("Existe el archivo o directorio? " + ruta + ": " + Files.exists(ruta));
             System.out.println("Es un directorio? " + ruta + ": " + Files.isDirectory(ruta));
             System.out.println("Es un archivo? " + ruta + ": " + Files.isRegularFile(ruta));
         }

        System.out.println("============== APARTADO D ==============");
        Path rutaAMover = Path.of("./empresa/nominas/2026_27/marzo.pdf");
        Path rutaDestino = Path.of("./empresa/nominas/2025_26");
        Files.copy(rutaAMover, rutaDestino.resolve(rutaAMover.getFileName()));

        System.out.println("============== APARTADO E ==============");
        /* Path rutaAMover = Path.of("./empresa/nominas/2026_27/enero.pdf");
        Path rutaDestino = Path.of("./empresa/nominas/2025_26");
        Files.move(rutaAMover, rutaDestino.resolve(rutaAMover.getFileName())); */

        /* System.out.println("============== APARTADO F ==============");
        Path rutaAEliminar = Path.of("./empresa/nominas/2026_27/febrero.pdf");
        Files.delete(rutaAEliminar); */
        // sale java.nio.file.NoSuchFileException

        System.out.println("============== APARTADO G ==============");
        Path rutaAContar = Path.of("./empresa/nominas/2025_26");
        List<Path> archivos = Files.list(rutaAContar).toList();
        for (Path archivo : archivos) {
            System.out.println("Archivo: " + archivo.getFileName());
        }
        input.close();
    }
}
