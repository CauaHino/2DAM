package es.ercilla.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	/**
	 * Esta clase es para no tener que crear objetos y simplificar el DAO
	 * 
	 */
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("examen");
	
	private JpaUtil() {
		
	}
	
	public static EntityManager getEntityManager() {
		return ENTITY_MANAGER_FACTORY.createEntityManager();
	}

}
