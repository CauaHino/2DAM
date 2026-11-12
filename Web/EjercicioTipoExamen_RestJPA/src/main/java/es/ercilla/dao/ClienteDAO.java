package es.ercilla.dao;

import es.ercilla.modelo.Cliente;
import es.ercilla.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ClienteDAO {
		
	public boolean insertar(Cliente c) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tr = em.getTransaction();
		
		try {
			tr.begin();
			em.persist(c);
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
	
	public Cliente obtenerPorId(int id) {
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			return em.find(Cliente.class, id);
		}finally {
			em.close();
		}
	}
}
