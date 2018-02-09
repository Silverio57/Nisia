package negocio;

import classes.ObjetoPersistivel;
import dao.GenericDAOImpl;
import dao.IGenericDAO;

/** Classe capaz de realizar cadastro/edição de quaisquer entidades do sistema.
 * @author João Paulo Nunes de lima
 * @since 13/12/2017
 */
public class ProcessadorCadastro extends ProcessadorComando {
	
	/** Objeto que se quer cadastrar/editar no banco. */
	protected ObjetoPersistivel obj;
	
	/* (non-Javadoc)
	 * @see negocio.ProcessadorComando#iniciarExecucao()
	 */
	@Override
	protected void iniciarExecucao() {
		IGenericDAO dao = new GenericDAOImpl();
		
		if (obj.getId() == 0){
			dao.create(obj);
		} else {
			dao.update(obj);
		}
	}

	/* (non-Javadoc)
	 * @see negocio.ProcessadorComando#getResultado()
	 */
	@Override
	protected Object getResultado() {
		return obj;
	}

	/**
	 * @param obj
	 */
	public void setObj(ObjetoPersistivel obj) {
		this.obj = obj;
	}
	
}
