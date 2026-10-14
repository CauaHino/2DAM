package es.ercilla.proceso.semaforo;

import java.io.IOException;

public class Cruce {

	public static void main(String[] args) {
		for (int ciclo = 1; ciclo <= 3; ciclo++) {
			System.out.println();
			System.out.println("======================");
			System.out.println("CICLO " + ciclo);
			System.out.println("======================");

			// FASE 1
			// Semáforo 1 en VERDE
			// Semáforo 2 en ROJO
			ejecutarDosSemaforos("SEMAFORO-1", "VERDE", 5, "SEMAFORO-2", "ROJO", 5);

			// FASE 2
			// Semáforo 1 pasa a AMARILLO
			// Semáforo 2 continúa en ROJO
			ejecutarDosSemaforos("SEMAFORO-1", "AMARILLO", 2, "SEMAFORO-2", "ROJO", 2);

			// FASE 3
			// Semáforo 1 en ROJO
			// Semáforo 2 en VERDE
			ejecutarDosSemaforos("SEMAFORO-1", "ROJO", 5, "SEMAFORO-2", "VERDE", 5);

			// FASE 4
			// Semáforo 1 continúa en ROJO
			// Semáforo 2 pasa a AMARILLO
			ejecutarDosSemaforos("SEMAFORO-1", "ROJO", 2, "SEMAFORO-2", "AMARILLO", 2);
		}

		System.out.println();
		System.out.println("Fin de la simulación.");
	}

	public static void ejecutarDosSemaforos(String nombre1, String color1, int segundos1, String nombre2, String color2,
			int segundos2) {

		ProcessBuilder pb1 = new ProcessBuilder("java", "src/es/ercilla/proceso/semaforo/Semaforo.java", nombre1,
				color1, String.valueOf(segundos1));
		ProcessBuilder pb2 = new ProcessBuilder("java", "src/es/ercilla/proceso/semaforo/Semaforo.java", nombre2,
				color2, String.valueOf(segundos2));

		pb1.inheritIO();
		pb2.inheritIO();

		try {

			// Los dos semáforos se ejecutan
			// simultáneamente
			Process proceso1 = pb1.start();
			Process proceso2 = pb2.start();

			// Esperamos a que terminen los dos
			proceso1.waitFor();
			proceso2.waitFor();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
