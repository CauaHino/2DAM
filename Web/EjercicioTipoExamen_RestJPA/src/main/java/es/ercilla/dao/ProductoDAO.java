package es.ercilla.dao;

import java.util.List;

import es.ercilla.modelo.Producto;
import es.ercilla.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ProductoDAO {
		
	public boolean insertarProducto(Producto p) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tr = em.getTransaction();
		
		try {
			tr.begin();
			em.persist(p);
			tr.commit();
			return true;
		}catch(Exception e) {
			if(tr.isActive()) {
				tr.rollback();
			}
			e.printStackTrace();
			return false;
		}finally {
			em.close();
		}
	}
	
	public List<Producto> buscarPorCategoria(String categoria){
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			return em.createQuery("Select p from Producto p where p.categoria = :categoria",Producto.class)
					.setParameter("categoria", categoria).getResultList();
					
		}finally {
			em.close();
		}
	}
}
