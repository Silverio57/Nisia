package anotacoes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author Silvério Rodrigues
 * @since 12 de Dezembro de 2017 
 */
public @interface EntityManagerFactory {
	
	EntityManagerFactory factory = (EntityManagerFactory) Persistence.createEntityManagerFactory("bancozao") ;
	
	EntityManager manager = ((javax.persistence.EntityManagerFactory)factory).createEntityManager () ;

}
