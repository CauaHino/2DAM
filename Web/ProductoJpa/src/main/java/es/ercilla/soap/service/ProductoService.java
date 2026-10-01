package es.ercilla.soap.service;

import es.ercilla.soap.dao.ProductoDAO;
import es.ercilla.soap.modelo.Producto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(name = "Producto", serviceName = "Producto")
public class ProductoService {
	
	@WebMethod(operationName ="insertarProducto")
	public String insertarProducto(@WebParam (name="Producto") Producto producto){
		ProductoDAO productoDAO = new ProductoDAO();
		try {
			productoDAO.insertarProducto(producto);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return producto + "guardado correctamente";
	}
	

}
