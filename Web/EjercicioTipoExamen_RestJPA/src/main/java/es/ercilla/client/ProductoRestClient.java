package es.ercilla.client;

import es.ercilla.config.ConfiguracionFinal;
import es.ercilla.modelo.Producto;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;

public class ProductoRestClient {
	private Client client;
	
	public ProductoRestClient() {
		this.client = ClientBuilder.newBuilder()
				.register(org.glassfish.jersey.jackson.JacksonFeature.class)
				.build();
	}
	
	public String insertar(Producto p) {
		return client.target(ConfiguracionFinal.URL_PRODUCTOS)
				.request(MediaType.TEXT_PLAIN)
				.post(Entity.entity(p, MediaType.APPLICATION_JSON),String.class);
		
		
	}
}
