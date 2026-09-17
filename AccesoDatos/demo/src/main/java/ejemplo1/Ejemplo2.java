package ejemplo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Ejemplo2 {
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("./AccesoDatos/demo/documents/texto.txt"));
            BufferedReader br = new BufferedReader(new FileReader("./AccesoDatos/demo/documents/texto.txt"))){
            bw.write("Hola mundo");
            bw.newLine();
            bw.write("Adios mundo");
            bw.flush(); // vaciar el buffer
            String linea = "";
            linea = br.readLine();
            while(linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
