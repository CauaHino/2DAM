package com.service;

import com.dao.ProductoDAO;
import com.modelo.Producto;
import com.modelo.request.ProductoRequest;
import com.modelo.response.ProductoResponse;
import com.utils.Utils;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
@WebService(name = "ProductoService", serviceName = "ProductoService")
public class ProductoService {
	ProductoDAO productoDAO = new ProductoDAO();
	
	@WebMethod(operationName = "createProducto")
	public String createProducto(@WebParam(name = "producto") ProductoRequest productoRequest) {
		Producto p = null;
		p = Utils.productoRequestToProducto(productoRequest);
		productoDAO.insertarProducto(p);
		return p.toString() + "Producto creado correctamente";
	}
	
	@WebMethod(operationName = "deleteProducto")
	public String deleteProducto(@WebParam(name = "producto") int idProducto) {
		Producto p = null;
		
		try {
			p = productoDAO.eliminarProducto(idProducto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p.toString() + "Producto borrado correctamente";
	}
	
	@WebMethod(operationName = "buscarProducto")
	public ProductoResponse buscarProducto(@WebParam(name = "producto") int idProducto) {
		ProductoResponse p = null;
		
		try {
			p = Utils.productoToProductoResponse(productoDAO.recuperarProductoPorId(idProducto));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return p;
	}
}
