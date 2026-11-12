package es.ercilla.services;

import es.ercilla.config.ConfiguracionProductoRestService;
import es.ercilla.modelos.Producto;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;

public class ProductoRestServiceCliente {
	private Client client = null;
	
	public ProductoRestServiceCliente() {
		this.client = ClientBuilder.newBuilder().register(org.glassfish.jersey.jackson.JacksonFeature.class).build();
		
	}
	
	public String insertar(Producto producto) {
		return client.target(ConfiguracionProductoRestService.URL_CONEXION).path("insertar").request(MediaType.TEXT_PLAIN)
				.post(Entity.entity(producto, MediaType.APPLICATION_JSON), String.class);
	}
	
	public String eliminar(Producto producto) {
		return client.target(ConfiguracionProductoRestService.URL_CONEXION).path("eliminar")
				.request(MediaType.TEXT_PLAIN).post(Entity.entity(producto, MediaType.APPLICATION_JSON),String.class);
	}
	
	public String actualizar(Producto producto, String nuevoNombre, String nuevaFamilia, int nuevoPrecio) {
		return client.target(ConfiguracionProductoRestService.URL_CONEXION).path("actualizar").path(nuevoNombre)
				.path(nuevaFamilia).path(String.valueOf(nuevoPrecio)).request(MediaType.TEXT_PLAIN)
				.post(Entity.entity(producto, MediaType.APPLICATION_JSON),String.class);
	}
	
}
