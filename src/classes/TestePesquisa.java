
package classes;

import java.util.List;
/**Nesta classe � realizada a pesquisa no banco de dados retornando 
 * informa��es desejadas.
 * @author Silv�rio Rodrigues
 * @since 22/12/2017
 */
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestePesquisa {

	/**
	 * @param args
	 */
	public static void main(String []args){
		
		
		javax.persistence.EntityManagerFactory factory = Persistence.createEntityManagerFactory("bancozao") ;
		
		EntityManager manager = factory.createEntityManager() ;
		 
		
		Query query = manager.createQuery(" SELECT e FROM Usuario e");
		List <Usuario> entrando = query.getResultList () ;
		
		 for(Usuario e:entrando ) {
			 System.out.println (" USUARIO: " + e.getNome() + " - " + e.getEmail() ) ;
		 }
		 
		 manager . close () ;
		 factory . close () ;

		 
		
	}
	
}