package com.dao;

import java.util.List;

import com.jpautil.JpaUtil;
import com.modelo.Cliente;
import com.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ClienteDAO {
	
	public void insertarCliente(Cliente cliente) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.persist(cliente);
			transaction.commit();
		}catch (Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}
	}
	
	public Cliente recuperarCliente(int idCliente) throws Exception{
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Cliente c = null;

		try {
			transaction.begin(); 
			c = entityManager.find(Cliente.class, idCliente);
			if(c == null) {
				throw new Exception("Producto no encontrado");
			}
		}catch (Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}
		return c;
		
	}
	
	public void actulizarCliente(Cliente cliente) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.merge(cliente);
			transaction.commit();
		}catch (Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}
	}
	
	public Cliente eliminarCliente(int idCliente) throws Exception{
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Cliente cliente = null;
		
		try {
			transaction.begin();
			cliente = entityManager.find(Cliente.class, idCliente);
			if(cliente == null) {
				throw new Exception("Producto no encontrado");
			}
			
			entityManager.remove(cliente);
			transaction.commit();
		}catch (Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}
		
		return cliente;
	}
	
	public String comprarProducto(int idCliente, int idFactura) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Cliente clienteR = null;
		Factura facturaR = null;
		
		try {
			transaction.begin();
			clienteR = entityManager.find(Cliente.class, idCliente);
			 facturaR = entityManager.find(Factura.class, idFactura);
			clienteR.getFacturas().add(facturaR);
			transaction.commit();
		}catch (Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();


				
			}
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}
		
		return clienteR.getNombre() + " ha comprado el producto " + facturaR; 
	}
	
	public List<Cliente> listarClientes() {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<Cliente> clientes = null;
		
		try {
			transaction.begin();
			clientes = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
			transaction.commit();
		}catch (Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}
		
		return clientes;
	}
}
