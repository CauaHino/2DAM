package es.ercilla.client;

import es.ercilla.config.ConfiguracionFinal;
import es.ercilla.modelo.Cliente;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;

public class ClienteRestClient {
	private Client client;
	
	public ClienteRestClient() {
		this.client = ClientBuilder.newBuilder()
				.register(org.glassfish.jersey.jackson.JacksonFeature.class)
				.build();
	}
	
	public String insertar(Cliente c) {
		return client.target(ConfiguracionFinal.URL_CLIENTES)
				.request(MediaType.TEXT_PLAIN)
				.post(Entity.entity(c, MediaType.APPLICATION_JSON),String.class);
	}
	
	public Cliente obtenerClienteId(int id) {
		return client.target(ConfiguracionFinal.URL_CLIENTES)
				.path(String.valueOf(id))
				.request(MediaType.APPLICATION_JSON)
				.get(Cliente.class);
	}
}
