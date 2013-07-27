package br.com.caelum.fj26.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("caelum-fj26");
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
