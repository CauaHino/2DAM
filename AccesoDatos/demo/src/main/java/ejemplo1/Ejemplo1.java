package ejemplo1;

import java.nio.file.Files;
import java.nio.file.Path;

public class Ejemplo1 {
    public static void main(String[] args) {
       Path ruta = Path.of("/documents/actividad.pdf");
       System.out.println(ruta);
       System.out.println(ruta.endsWith("actividad.pdf"));
       System.out.println(ruta.getParent());
    }
}
