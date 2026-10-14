package com.utils;

import java.util.ArrayList;
import java.util.List;

import com.modelo.Cliente;
import com.modelo.Factura;
import com.modelo.Producto;
import com.modelo.request.ClienteRequest;
import com.modelo.request.FacturaRequest;
import com.modelo.request.ProductoRequest;
import com.modelo.response.ClienteResponse;
import com.modelo.response.FacturaResponse;
import com.modelo.response.ProductoResponse;
import com.service.ClienteService;
import com.service.ProductoService;

public class Utils {
	private static ClienteService clienteService = new ClienteService();
	private static ProductoService productoService = new ProductoService();

	//Producto Mapper
	
	public static Producto productoRequestToProducto(ProductoRequest pR) {
		Producto p = new Producto();
		p.setNombre(pR.getNombre());
		p.setFamilia(pR.getFamilia());
		return p;
	}

	public static Producto productoResponseToProducto(ProductoResponse pR) {
		Producto p = new Producto();
		
		p.setIdProducto(pR.getIdProducto());
		p.setFamilia(pR.getFamilia());
		p.setNombre(pR.getNombre());
		
		return p;
	}

	public static ProductoResponse productoToProductoResponse(Producto p) {
		ProductoResponse pR = new ProductoResponse();
		
		pR.setIdProducto(p.getIdProducto());
		pR.setNombre(p.getNombre());
		pR.setFamilia(p.getFamilia());
		
		return pR;
	}

	//Cliente Mapper
	public static Cliente clienteRequestToCliente(ClienteRequest cR) {
		Cliente c = new Cliente();
		c.setDocumento(cR.getDocumento());
		c.setNombre(cR.getNombre());
		c.setApellidos(cR.getApellidos());
		return c;
	}

	public static Cliente clienteResponseToCliente(ClienteResponse cR) {
		Cliente c = new Cliente();
		
		c.setIdCliente(cR.getIdCliente());
		c.setDocumento(cR.getDocumento());
		c.setNombre(cR.getNombre());
		c.setApellidos(cR.getApellidos());
		
		return c;
	}

	public static ClienteResponse clienteToClienteResponse(Cliente c) {
		ClienteResponse cR = new ClienteResponse();
		
		cR.setIdCliente(c.getIdCliente());
		cR.setDocumento(c.getDocumento());
		cR.setNombre(c.getNombre());
		cR.setApellidos(c.getApellidos());
		
		return cR;
	}

	//Factura Mapper
	
	public static Factura requestFacturaToFactura(FacturaRequest fR) {
		Factura factura = new Factura();
		Cliente cliente = new Cliente();
		ClienteResponse cR = new ClienteResponse();
		
		cR = clienteService.buscarCliente(fR.getIdCliente());
		cliente = Utils.clienteResponseToCliente(cR);
		
		factura.setTotal(fR.getTotal());
		factura.setCliente(cliente);
		factura.setProductos(Utils.getProductosFromIds(fR.getIdsProducto()));
		
		return factura;
	}

	public static FacturaResponse facturaToFacturaResponse(Factura factura){
		FacturaResponse fR = new FacturaResponse();

		fR.setCliente(factura.getCliente());
		fR.setListaProductos(factura.getProductos());
		fR.setIdFactura(factura.getIdFactura());

		return fR;
	}

	// Utilities 

	public static List<Producto> getProductosFromIds(List<Integer> idsProducto) {
		List<Producto> productos = new ArrayList<Producto>();
		ProductoResponse pR = new ProductoResponse();
		Producto p = new Producto();
		
		for (Integer id : idsProducto) {
			pR = productoService.buscarProducto(id);
			p = Utils.productoResponseToProducto(pR);
			productos.add(p);
		}
		
		return productos;
	}

}
