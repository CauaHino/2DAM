package ejemplo1;

import java.nio.file.Files;
import java.nio.file.Path;

public class Ejemplo1 {
    public static void main(String[] args) {
       Path ruta = Path.of("./AccesoDatos/demo/documents/actividad.pdf");
       Path ruta2 = Path.of("./AccesoDatos/demo/documents/imagen.png");
       System.out.println(ruta);
       System.out.println(ruta.endsWith("actividad.pdf"));
       System.out.println(ruta.getParent());
       System.out.println(Files.exists(ruta));
       try {
        if(!Files.exists(ruta)) {
            Files.createFile(ruta);
        }
        Path ruta3 = Path.of("./AccesoDatos/demo/documents/test"); 
        Files.deleteIfExists(ruta3);
       } catch (Exception e) {
       e.printStackTrace();
       }

       // Hacer un copy de la ruta1 para una nueva ruta
         Path ruta4 = Path.of("./AccesoDatos/demo/documents/2027");
         try{
            if(!Files.exists(ruta4)){
                Files.createDirectory(ruta4);   
            }
            Files.copy(ruta, ruta4.resolve("actividad.pdf"));
            
         } catch (Exception e) {
            e.printStackTrace();
         }

         // Hacer un move de la ruta2 para una nueva ruta
         Path ruta5 = Path.of("./AccesoDatos/demo/documents/2027/actividad.pdf");
         Path ruta6 = Path.of("./AccesoDatos/demo/documents/2028");
         try{
            if(!Files.exists(ruta6)){
                Files.createDirectory(ruta6);   
            } else if(Files.exists(ruta5)){
                Files.move(ruta5, ruta6.resolve(ruta5.getFileName()));
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
        
    }
}
