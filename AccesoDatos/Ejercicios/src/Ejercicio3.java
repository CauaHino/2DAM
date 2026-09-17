import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ejercicio3 {
    public static void main(String[] args) {
        imprimirHijosDeDirectorios(Path.of("./biblioteca"), 0);
    }

    static void imprimirHijosDeDirectorios(Path padre, int nivel) {
        if(!Files.isDirectory(padre)) {
            return;
        }

        List<Path> hijos;
        try {
            hijos = Files.list(padre).toList();
            for (Path hijo : hijos) {
                for (int i = 0; i < nivel; i++) {
                    System.out.print("  ");
                }
            System.out.println(hijo.getFileName());
            imprimirHijosDeDirectorios(hijo, nivel + 1);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}   
