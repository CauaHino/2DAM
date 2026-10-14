package procesos;

import java.io.IOException;

public class Proceso {

	public static void main(String[] args) {
		String nombre = "archivo";
		String ruta = "C:/Users/cauah/Documents/2DAM/PSP/EjempoHilosFichero/src/ficheros/";

		for (int i = 1; i <= 100; i++) {
			ProcessBuilder pb = new ProcessBuilder("java",
					"src/crear/ficheros/CrearFicheros.java",
					nombre + i + ".txt", ruta);
			try {
				Process archivo = pb.start();
				System.out.println(archivo.pid() + "creado");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
