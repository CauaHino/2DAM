package es.ercilla.proceso.semaforo;

public class Semaforo {

	public static void main(String[] args) {
		String nombre = args[0];
		String color = args[1];
		int segundos = Integer.parseInt(args[2]);
		System.out.println(nombre + " -> " + color);
		for (int i = segundos; i > 0; i--) {
			System.out.println(nombre + " [" + color + "] -> " + i + " segundos");
		}
		System.out.println(nombre + " termina estado " + color);
	}
}
