package ejemplosut1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class EjemploGson {
    public static void main(String[] args) {
        String rutaFichero = "./AccesoDatos/ejemplosut1/persona.json";

        try{
            
            Path fichero = Path.of(rutaFichero);

            // Creo fichero
            if (!Files.exists(fichero))
                Files.createFile(fichero);

            Persona p1 = new Persona("Daniel", 19);
            Persona p2 = new Persona("Víctor", 22);

            ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

            listaPersonas.add(p1);
            listaPersonas.add(p2);

            // Escritura de personas
            // Creo una instancia Gson para manejar lecturas y escrituras
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // me creo el flujo de escritura
            FileWriter fw  = new FileWriter(rutaFichero);

            // transforma la lista de personas a un array JSON y lo meta en el fichero
            gson.toJson(listaPersonas, fw);

            // para que se apliquen los cambios hay que cerrar el archivo
            fw.close();

            // Lectura de personas
            FileReader fr = new FileReader(rutaFichero);

            // Me creo un tipo específico para que Gson comprenda el contenido del fichero JSON
            Type tipoLista = new TypeToken<List<Persona>>() {}.getType();


            // Leo el fichero json y transformo el contenido en un lista de personas
            List<Persona> personas = Arrays.asList(gson.fromJson(fr, Persona[].class));

            fr.close();
            
            System.out.println(personas);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
