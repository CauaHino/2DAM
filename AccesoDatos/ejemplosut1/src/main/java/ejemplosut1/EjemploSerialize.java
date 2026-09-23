package ejemplosut1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class EjemploSerialize {

    public static void main(String[] args) {
        
        String rutaFichero = "./persona.bin";
        Path fichero = Path.of(rutaFichero);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero))) {
            if (!Files.exists(fichero)) {
                Files.createFile(fichero);
            }

            Persona p1 = new Persona("Daniel", 19);
            Persona p2 = new Persona("Víctor", 22);
                
            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.close();

            // 2. Lectura (Deserialization)
            FileInputStream fis = new FileInputStream(rutaFichero);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Persona p11 = (Persona) ois.readObject();
            Persona p12 = (Persona) ois.readObject();
            ois.close();

                // Mostramos por consola los objetos leídos
            System.out.println(p11);
            System.out.println(p12);
            

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } 
    }
}