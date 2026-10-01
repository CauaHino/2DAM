package es.ercilla.soap.jpautil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("productosPU");

	private JpaUtil(){
	}

	public static EntityManager getEntityManager(){
		return ENTITY_MANAGER_FACTORY.createEntityManager();
	}

}
