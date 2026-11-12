package es.ercilla.dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import es.ercilla.modelo.Cliente;
import es.ercilla.modelo.Factura;
import es.ercilla.modelo.Producto;
import es.ercilla.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class FacturaDAO {
	
	
	public boolean crearFacturaDeVenta(int idCliente, List<Integer> idsProductos, Factura f) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tr = em.getTransaction();
		double importeTotal = 0;
		
		try {
			tr.begin();
			

			Cliente c = em.find(Cliente.class, idCliente);
			if(c == null) {
				return false;
			}
			

			List<Producto> productosComprados = new ArrayList<>();
			
			for(Integer idProducto : idsProductos) {
				Producto p = em.find(Producto.class, idProducto);
				if(p != null) {
					productosComprados.add(p);
					importeTotal += p.getPrecio();
				}
			}
			
			f.setCliente(c);
			f.setProductos(productosComprados);
			f.setImporteTotal(importeTotal);
			
			em.persist(f);
			tr.commit();
			return true;
			
		} catch(Exception e) {
			if(tr.isActive()) {
				tr.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}
	public List<Factura> listaFacturas(){
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			return em.createQuery("Select f from Factura f",Factura.class).getResultList();
		}finally {
			em.close();
		}
	}
	
	public Factura verFactura(int id) {
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			return em.find(Factura.class, id);
		}finally {
			em.close();
		}
	}
}
