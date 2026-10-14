package crear.ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CrearFicheros {
	public static void main(String[] args) {
//		args[0] = "archivo.txt";
//		args[1] = "./ficheros/";
		String nombre = args[0];
		String ruta = args[1];
		crearFichero(nombre, ruta);		
	}
	
	public static void crearFichero(String nombre, String ruta) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(ruta + nombre))){
			bw.write(nombre);
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
