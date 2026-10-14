package com.dao;

import com.jpautil.JpaUtil;
import com.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class FacturaDAO {
    public void insertarFactura(Factura factura) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			transaction.begin();
			entityManager.persist(factura);
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
    
    public Factura buscarFacturaPorId(int idFactura) throws Exception{
    	EntityManager entityManager = JpaUtil.getEntityManager();
    	EntityTransaction transaction = entityManager.getTransaction();
    	Factura f = null;
    	
    	try {
			transaction.begin();
			f = entityManager.find(Factura.class, idFactura);
	    	if (f == null) {
				throw new Exception("Factura " + idFactura + " no encontrada");
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
    	
    	return f;
    }
    
    public Factura eliminarPorId(int idFactura) throws Exception {
    	EntityManager entityManager = JpaUtil.getEntityManager();
    	EntityTransaction transaction = entityManager.getTransaction();
    	Factura f = null;
    	
    	try {
			transaction.begin();
			f = entityManager.find(Factura.class, idFactura);
			
			if(f == null) {
				throw new Exception("Factura " + idFactura + " no encontrada");
			}
			
			entityManager.remove(f);
			transaction.commit();
		} catch (Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}
    	
    	return f;
    }
    
}
