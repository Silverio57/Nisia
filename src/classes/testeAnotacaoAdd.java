package classes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import anotacoes.EntityManagerFactory;
import anotacoes.Testefoda;
/**Usada para outro teste onde a informações de um usuário são 
 * adicionadas ao banco de dados.
 * @author João Paulo Nunes de lima
 * @since 22/12/2017
 */
public class testeAnotacaoAdd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		javax.persistence.EntityManagerFactory factory = Persistence.createEntityManagerFactory("bancozao") ;
		
		EntityManager manager = factory.createEntityManager() ;

		
		
		Testefoda novoNome = new Testefoda();
		
		novoNome.setNome("silverio");
		novoNome.setEmail("silva@email.com");
		
		manager.persist(novoNome);
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		
		
		
		
	}
	
}
