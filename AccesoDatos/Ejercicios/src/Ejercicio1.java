import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio1 {
    public static void main(String[] args) {
        Path ruta = Path.of("./documentos/ejemplo.txt");

        System.out.println("============== APARTADO A ==============");
        System.out.println("Nombre del archivo: " + ruta.getFileName());
        System.out.println("Directorio padre: " + ruta.getParent());
        System.out.println("¿Es ruta absoluta? " + ruta.isAbsolute());
        System.out.println("La ruta como String: " + ruta.toString());

        System.out.println("============== APARTADO B ==============");
        Path ruta2 = Path.of("./documentos/ejemplo.txt");
        System.out.println("¿Son iguales las rutas? " + ruta.compareTo(ruta2));
        Path ruta3 = Path.of("/documentos/ejemplo2.txt");
        System.out.println("¿Son iguales las rutas? " + ruta.compareTo(ruta3));

        System.out.println("============== APARTADO C ==============");
        System.out.println("¿Termina con 'ejemplo.txt'? " + ruta.endsWith("ejemplo.txt"));
        Path ruta4 = Path.of("./documentos/ejemplo.pdf");
        System.out.println("¿Termina con 'ejemplo.pdf'? " + ruta4.endsWith("ejemplo.pdf"));
    }

}
