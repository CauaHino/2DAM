package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.ClienteDAO;
import com.modelo.Cliente;
import com.modelo.request.ClienteRequest;
import com.modelo.response.ClienteResponse;
import com.utils.Utils;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(name = "ClienteService", serviceName = "ClienteService")
public class ClienteService {
	ClienteDAO clienteDAO = new ClienteDAO();
	
	@WebMethod(operationName = "insertarCliente")
	public String insertarCliente(@WebParam(name = "cliente")ClienteRequest cliente) {
		Cliente c = null;
		
		c = Utils.clienteRequestToCliente(cliente);
		clienteDAO.insertarCliente(c);
		
		return c.toString() + "Cliente creado";
	}
	
	@WebMethod(operationName = "comprarProducto")
	public String comprarProducto(@WebParam(name = "idCliente") int idCliente, @WebParam(name = "idProducto") int idProducto) {
		return clienteDAO.comprarProducto(idCliente, idProducto);
	}
	
	@WebMethod(operationName = "listarClientes")
	public String listarClientes() {
		List<ClienteResponse> clientesResponse = new ArrayList<>();

		for (Cliente c : clienteDAO.listarClientes()) {
			clientesResponse.add(Utils.clienteToClienteResponse(c));
		}
		
		return clientesResponse.toString();
	}
	
	@WebMethod(operationName = "borrarCliente")
	public String borrarCliente(@WebParam(name = "cliente") int idCliente) {
		Cliente c = null;
		
		try {
			c = clienteDAO.eliminarCliente(idCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c.toString();
	}
	
	@WebMethod(operationName = "buscarCliente")
	public ClienteResponse buscarCliente(@WebParam(name = "cliente") int idCliente) {
		Cliente c = null;
		
		try {
			c = clienteDAO.recuperarCliente(idCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Utils.clienteToClienteResponse(c);
	}
}
