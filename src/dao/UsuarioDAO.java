package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import classes.Usuario;
import utilitarios.ValidatorUtil;



/**
 * DAO (Data Access Object - Objeto de Acesso a Dados) com 
 * métodos relativos à entidade {@link Usuario}.
 * @since 11/12/2017
 */

public class UsuarioDAO extends GenericDAOImpl {

	/** Encontra um usuário a partir de seu login e senha. */
	/**
	 * @param login
	 * @param senha
	 * @return
	 */
	public Usuario findUsuarioByLoginSenha(String login, String senha){
		EntityManager em = getEm();
		
		String hql = "SELECT usuario ";
		hql += " FROM Usuario usuario WHERE usuario.email = :login and usuario.senha = :senha ";
		
		Query q = em.createQuery(hql);
		q.setParameter("login", login);
		q.setParameter("senha", senha);
		
		try {
			Usuario usuario = (Usuario) q.getSingleResult();
			return usuario;
		} catch (NoResultException e){
			return null;
		}
	}
	
	/** Método que permite listar usuários através da busca por
	 * diversos atributos.
	 */
	
	/** Encontra usuarios so pelo email. */
	public List<Usuario> findUsuarioGeral(String email, String ordenarPor){
		EntityManager em = getEm();
		
		String hql = "SELECT u ";
		hql += " FROM Usuario u WHERE 1=1";
		
		if (ValidatorUtil.isNotEmpty(email)){
			hql += " AND u.email = :email ";
		}
		
		if (ValidatorUtil.isNotEmpty(ordenarPor)){
			hql += " ORDER BY :ordenarPor ";
		}
		
		Query q = em.createQuery(hql);
		
		if (ValidatorUtil.isNotEmpty(email)){
			q.setParameter("email", email);
		}
		if (ValidatorUtil.isNotEmpty(nome)){
			q.setParameter("nome", "%" + nome.toUpperCase() + "%");
		}
		if (ValidatorUtil.isNotEmpty(senha)){
			q.setParameter("senha", "%" + senha.toUpperCase() + "%");
		}
		if (ValidatorUtil.isNotEmpty(ordenarPor)){
			q.setParameter("ordernarPor", ordenarPor);
		}
		
		try {
			@SuppressWarnings("unchecked")
			List<Usuario> result = q.getResultList();
			
			return result;
		} catch (NoResultException e){
			return null;
		}
	}
	
}
