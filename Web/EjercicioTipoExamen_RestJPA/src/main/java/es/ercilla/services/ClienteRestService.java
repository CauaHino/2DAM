package es.ercilla.services;

import es.ercilla.dao.ClienteDAO;
import es.ercilla.modelo.Cliente;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/clientes")
public class ClienteRestService {
	private ClienteDAO clienteDAO = new ClienteDAO();
		
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertar(Cliente c) {
		boolean exito = clienteDAO.insertar(c);
		
		if(exito) {
			return "Cliente insertado con exito";
		}else {
			return "Error al insertar cliente";
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente obtenerCliente(@PathParam("id")int id) {
		return clienteDAO.obtenerPorId(id);
	}
}
