package es.ercilla.services;

import java.util.List;

import es.ercilla.dao.FacturaDAO;
import es.ercilla.modelo.Factura;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/facturas")
public class FacturaRestService {
	private FacturaDAO facturaDAO = new FacturaDAO();
	
	@POST
	@Path("/cliente/{idCliente}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearFacturasDeVenta(@PathParam("idCliente")int id,List<Integer>idsProductos) {
		
		Factura f = new Factura();
		boolean exito = facturaDAO.crearFacturaDeVenta(id, idsProductos, f);
		
		if(exito) {
			return "Factura de venta creada correctamente";
		}else {
			return "Error al crear la factura de venta";
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Factura verFactura(@PathParam("id") int id) {
		return facturaDAO.verFactura(id); // Usa el método de tu DAO que busque por ID
	}
}
