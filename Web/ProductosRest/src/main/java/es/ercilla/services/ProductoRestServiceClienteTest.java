package es.ercilla.services;

import es.ercilla.modelos.Producto;

public class ProductoRestServiceClienteTest {
	public static void main(String[] args) {
		Producto producto = new Producto("Colonia","Perfumeria",15);
		ProductoRestServiceCliente productoRestServiceCliente = new ProductoRestServiceCliente();
		System.out.println(productoRestServiceCliente.insertar(producto));
		System.out.println(productoRestServiceCliente.eliminar(producto));
		System.out.println(productoRestServiceCliente.insertar(producto));
		System.out.println(productoRestServiceCliente.actualizar(producto,"Perfume","Perfumeria",100));
	}

}
