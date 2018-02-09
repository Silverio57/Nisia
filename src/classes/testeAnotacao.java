package classes;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**Classe utilizada para realização de testes com o intuito de saber o real 
 * funcionamento da aplicação
 * @author Silvério Rodrigues
 * @since 22/12/2017
 */
public class testeAnotacao {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence . createEntityManagerFactory ("bancozao") ;
	
		factory . close () ;
		
	}

}


