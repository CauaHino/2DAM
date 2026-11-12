package es.ercilla.services;

import java.util.List;

import es.ercilla.dao.ProductoDAO;
import es.ercilla.modelo.Producto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/productos")
public class ProductoRestService {
	private ProductoDAO productoDAO = new ProductoDAO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertarProducto(Producto p) {
		boolean exito = productoDAO.insertarProducto(p);
		
		if(exito) {
			return "Producto insertado correctamente";
		}else {
			return "Error al insertar el producto";
		}
	}
	
	@GET
	@Path("/categoria")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> buscarCategoria(@QueryParam("categoria")String categoria){
		return productoDAO.buscarPorCategoria(categoria);
	}
}
