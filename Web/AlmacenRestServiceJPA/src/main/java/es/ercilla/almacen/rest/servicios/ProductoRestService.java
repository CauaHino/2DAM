package es.ercilla.almacen.rest.servicios;

import es.ercilla.almacen.rest.dao.ProductoDAO;
import es.ercilla.almacen.rest.modelo.Producto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/productos")
public class ProductoRestService {

	ProductoDAO productoDAO = new ProductoDAO();
	
	@GET
	@Path("/ejemplo")
	@Produces(MediaType.TEXT_PLAIN)
	
	public String ejemplo() {
		return "Hola mundo";
	}
	
	@POST
	@Path("/insertar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String insertar(Producto producto) {
		String resultado = "";
		if (productoDAO.insertarProducto(producto)) {
			resultado = "Se ha insertado el producto: " + producto.toString();
		} else {
			resultado = "Se ha producido un error al insertar el Producto: " + producto.toString();
		}
		
		return resultado;
	}
	
	@GET
	@Path("/getById/{idProducto}")
	// @Consumes(MediaType.APPLICATION_JSON) si se pone el parametro en el path
	// NO poner el @Consumes porque puede dar error
	@Produces(MediaType.APPLICATION_JSON)
	
	public Producto getById(@PathParam("idProducto") int idProducto) {
		Producto producto = productoDAO.recuperarProductoPorId(idProducto);
		
		return producto;
	}
	
	// Hacer metodo delete
	
	@POST
	@Path("/eliminar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String eliminar(int idProducto) {
		String resultado = "";
		Producto producto = productoDAO.eliminarProducto(idProducto);
		if(producto != null) {
			resultado = "Se ha eliminado el producto: " + producto.toString();
		} else {
			resultado = "No existe el producto con ID: " + idProducto;
		}
		
		return resultado;
	}
	
}
