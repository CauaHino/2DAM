package com.dao;

import com.jpautil.JpaUtil;
import com.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ProductoDAO {
	public void insertarProducto(Producto producto) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			transaction.begin();
			entityManager.persist(producto);
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
	
	public Producto recuperarProductoPorId(int idProducto) throws Exception{
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Producto p = null;
		
		try {
			transaction.begin();
			p = entityManager.find(Producto.class, idProducto);
			if(p == null) {
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
		return p;
	}
	
	public void actualizarProducto(Producto producto) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			transaction.begin();
			entityManager.merge(producto);
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
	
	public Producto eliminarProducto(int idProducto) throws Exception{
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Producto p = null;
		
		try {
			transaction.begin();
			p = entityManager.find(Producto.class, idProducto);
			if(p == null) {
				throw new Exception("Producto no encontrado");
			}
			
			entityManager.remove(p);
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
		
		return p;
	}
}
