package es.ercilla.test;

import java.util.ArrayList;
import java.util.List;

import es.ercilla.client.ClienteRestClient;
import es.ercilla.client.FacturaRestClient;

public class TestMetodos {
	public static void main(String[] args) {
		
		FacturaRestClient facturaRest = new FacturaRestClient();
		
		System.out.println("---INICIANDO PRUEBA DE FACTURA---");
		
		// 1. COMENTAMOS LAS INSERCIONES DE CLIENTE Y PRODUCTO
		// Ya existen en la BD, no necesitamos volver a crearlos y provocar el error ORA-00001.

		// 2. CREAMOS DIRECTAMENTE LA FACTURA
		System.out.println("\nFactura: ");
		List<Integer> idsProductos = new ArrayList<>();
		idsProductos.add(1); // Añadimos el Producto 1
		idsProductos.add(2); // Añadimos el Producto 2 (opcional)
		
		// Pasamos el ID 1 (Ana) y la lista de IDs de productos
		// System.out.println("Servidor dice: " + facturaRest.crearFactura(1, idsProductos));
		
		ClienteRestClient cRest = new ClienteRestClient(); 
		System.out.println(cRest.obtenerClienteId(1));
	}
}