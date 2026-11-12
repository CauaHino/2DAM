package es.ercilla.client;

import java.util.List;

import es.ercilla.config.ConfiguracionFinal;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;

public class FacturaRestClient {
	private Client client;
	
	public FacturaRestClient() {
		this.client = ClientBuilder.newBuilder()
				.register(org.glassfish.jersey.jackson.JacksonFeature.class)
				.build();
	}
	
	public String crearFactura(int idCliente,List<Integer>idsProductos) {
		return client.target(ConfiguracionFinal.URL_FACTURAS)
				.path("cliente")//añade /cliente en la url
				.path(String.valueOf(idCliente))
				.request(MediaType.TEXT_PLAIN)
				.post(Entity.entity(idsProductos, MediaType.APPLICATION_JSON)
						,String.class);
	}
}
