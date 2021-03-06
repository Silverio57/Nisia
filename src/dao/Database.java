package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;


/** Classe que controla a comunica��o com o banco de dados, inclusive o
 * gerenciamento de entidades (EntityManager). Esta classe � um singleton, ou
 * seja, s� pode existir uma ocorr�ncia (objeto) dela em todo o sistema.
 * @author Jo�o Paulo Nunes de Lima
 * @since 13/12/2017
 */


public class Database {

	private static Database singleton = new Database();
	private static EntityManager em;

	private Database() {
		criarEM();
	}

	private void criarEM() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("NisiaBD");
		/** O nome NisiaBD � o mesmo que est� no arquivo persistence.xml */
		em = emf.createEntityManager();
	}

	/**
	 * @return
	 */
	public static Database getInstance() {
		return singleton;
	}

	/**
	 * @return
	 */
	public EntityManager getEntityManager() {
		if (!em.isOpen()) {
			criarEM();
		}

		return em;
	}

	/**
	 * @return
	 */
	public Session getSession() {
		return (Session) em.getDelegate();
	}

}
