package controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import anotacoes.Testefoda;
import classes.Usuario;				/** Importacao da classe com os atributos da conta */
import bancoDados.ConnectorFactory;		/** Importacao da classe que executa a conexao com o SGBD */

/**MBean incompleto 
 * @author João Paulo Nunes de Lima
 * @since 23/12/2017
 * */

@ManagedBean
public class UsuarioMBean {

	private Usuario dados= new Usuario();
	
	private List<Usuario> dadosUser = new ArrayList<Usuario>();
	
	/**metodo para adicionar os dados de cadastro no SGBD */
	
	javax.persistence.EntityManagerFactory factory = Persistence.createEntityManagerFactory("bancozao") ;
	EntityManager manager = factory.createEntityManager() ;
	
	public void cadastrar(){
		
		
		manager.persist(dados);
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		
		manager.close () ;
		factory.close () ;

		
	}

	
	public void logar(){
		
		 System.out.println ("executouy" ) ;
		
		 Query query = manager.createQuery(" SELECT e FROM Usuario e");
		 List <Usuario> entrando = query.getResultList () ;
		
		 for(Usuario e:entrando ) {
			 System.out.println (" USUARIO: " + e.getNome() + " - " + e.getEmail() ) ;
		 }
		 
		 manager.close () ;
		 factory.close () ;

		 
	}
	
	
	public Usuario getDados() {
		return dados;
	}

	public void setDados(Usuario dados) {
		this.dados = dados;
	}

	public List<Usuario> getDadosUser() {
		return dadosUser;
	}

	public void setDadosUser(List<Usuario> dadosUser) {
		this.dadosUser = dadosUser;
	}
	
	
	
	
	
}
