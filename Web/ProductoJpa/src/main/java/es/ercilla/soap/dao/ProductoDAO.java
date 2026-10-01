package es.ercilla.soap.dao;

import es.ercilla.soap.jpautil.JpaUtil;
import es.ercilla.soap.modelo.Producto;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transaction;

public class ProductoDAO {
	
	public void insertarProducto(Producto producto){
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		try{
			transaction.begin();
			entityManager.persist(producto);
			transaction.commit();
		}catch(Exception e){
			if(transaction.isActive()){
				transaction.rollback();		
			}
			e.printStackTrace();
		}finally{
			entityManager.close();
		}
	}
	
	public void actualizarProducto(Producto p) {
		EntityTransaction transaction = null;
		try(EntityManager entityManager = JpaUtil.getEntityManager()){
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.merge(p);
			transaction.commit();
		} catch(Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	
	public void eliminarProducto(int idProducto) {
		EntityTransaction transaction = null;
		Producto p = null;
		try(EntityManager entityManager = JpaUtil.getEntityManager()){
			transaction = entityManager.getTransaction();
			p = entityManager.find(Producto.class, p);
			entityManager.remove(p);
		} catch(Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

}
