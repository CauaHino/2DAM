package ejemplosut1;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class EjemploGson2 {
    public static void main(String[] args) {
        String rutaFichero = "persona.json";

        try{
            Path fichero = Path.of(rutaFichero);

            if (!Files.exists(fichero))
                Files.createFile(fichero);

            // JsonObject para crea una representación JSONN de una persona
            // con addProperty() asigno un nuevo atributo al objeto
            JsonObject p1 = new JsonObject();
            p1.addProperty("nombre", "Pedro");
            p1.addProperty("edad", 19);

            JsonObject p2 = new JsonObject();
            p2.addProperty("nombre", "María");
            p2.addProperty("edad", 35);

            JsonArray listaPersonas = new JsonArray();
            listaPersonas.add(p1);
            listaPersonas.add(p2);

            // escribir la lista de personas en el fichero
            FileWriter fw = new FileWriter(rutaFichero);

            Gson gson = new Gson();
            gson.toJson(listaPersonas, fw);

            fw.close();

            // Para leer ahora hacemos lo siguiente
            FileReader fr = new FileReader(rutaFichero);
            JsonArray listaPersonasGuardadas = gson.fromJson(fr, JsonArray.class);
            System.out.println(listaPersonasGuardadas);

            // Recorrer el array JSON que avabamos de leer del fichero

            for (JsonElement jsonElement : listaPersonasGuardadas){
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String nombrePersona = jsonObject.get("nombre").getAsString();
                int edadPersona = jsonObject.get("edad").getAsInt();

                System.out.println(nombrePersona + " - " + edadPersona);
            }



            fr.close();


        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
