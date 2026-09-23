import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio4 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("./blocs/bloc_CAUA.txt"))) {
            ArrayList<Character> caracteres = new ArrayList<>();
            int c;
            while((c = br.read()) != -1) {
                caracteres.add((char) c);
            }
            System.out.println(caracteres.size());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    }
