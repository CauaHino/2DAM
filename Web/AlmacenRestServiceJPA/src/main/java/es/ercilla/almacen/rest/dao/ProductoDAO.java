package es.ercilla.almacen.rest.dao;

import es.ercilla.almacen.rest.modelo.Producto;
import es.ercilla.almacen.rest.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ProductoDAO {

	public boolean insertarProducto(Producto producto) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			transaction.begin();
			entityManager.persist(producto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			entityManager.close();
		}
	}
	
	public Producto recuperarProductoPorId(int idProducto) {//throws Exception{
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Producto producto = null;
		
		try {
			transaction.begin();
			producto = entityManager.find(Producto.class, idProducto);
			if(producto == null) {
				//throw new ProductoDAOException(Mensajes.
				//		obtenerMensajeParametros("mensaje.productoDAOException.productoNoEncontrado", idProducto));
			}
		} catch (Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			//throw e;
		} finally {
			entityManager.close();
		}
		
		return producto;
		
	}
	
	public void actualizarProducto(Producto producto) { //throws ProductoDAOException {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			transaction.begin();
			entityManager.merge(producto);
			transaction.commit();
			
		} catch (Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			//throw new ProductoDAOException(e.getMessage());
		} finally {
			entityManager.close();
		}
		
	}
	
	public Producto eliminarProducto(int idProducto) {//throws ProductoDAOException {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Producto producto = null;
		
		try {
			transaction.begin();
			producto = entityManager.find(Producto.class, idProducto);
			if(producto == null) {
				//throw new ProductoDAOException(Mensajes.
				//		obtenerMensajeParametros("mensaje.productoDAOException.productoNoEncontrado", idProducto));
				entityManager.remove(producto);
				transaction.commit();
				return producto;
			}
			
		} catch (Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			//throw e;
		} finally {
			entityManager.close();
		}
		
		return producto;
		
	}
}
