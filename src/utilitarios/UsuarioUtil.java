package utilitarios;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import classes.Usuario;


/** Classe com métodos úteis relativos a usuários do sistema.
 * @author João Paulo Nunes de lima
 * @since 13/12/2017
 */


public class UsuarioUtil {
	
	/** Obtém o usuário logado no sistema. */
	/**
	 * @return
	 */
	public static Usuario getUsuarioLogado(){
		if (FacesContext.getCurrentInstance() == null)
			return null;
		
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return (Usuario) req.getSession().getAttribute("usuarioLogado");
	}

}
