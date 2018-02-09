package utilitarios;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import classes.Usuario;


/** Classe com m�todos �teis relativos a usu�rios do sistema.
 * @author Jo�o Paulo Nunes de lima
 * @since 13/12/2017
 */


public class UsuarioUtil {
	
	/** Obt�m o usu�rio logado no sistema. */
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
