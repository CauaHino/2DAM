import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Ejercicio12 {
    public static void main(String[] args) {
        JsonArray listaJuegos = new JsonArray();
        try(BufferedReader br = new BufferedReader(new FileReader("./videojuegos.csv")); 
            BufferedWriter bw = new BufferedWriter(new FileWriter("./videojuegos.json"))){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String cabeceraString = br.readLine();
            List<String> cabecera = Arrays.asList(cabeceraString.split(";"));
            String linea = br.readLine();
            while(linea != null){
                JsonObject juego = new JsonObject();
                List<String> juegos = new ArrayList<>();
                juegos = Arrays.asList(linea.split(";"));
                for(String informacion : juegos){
                    for(String cabeceras : cabecera){
                        if(!juego.has(cabeceras)){
                            juego.addProperty(cabeceras, informacion);
                            break;
                        }
                    }
                }
             listaJuegos.add(juego);   
             linea = br.readLine();
            }
           gson.toJson(listaJuegos, bw);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
}