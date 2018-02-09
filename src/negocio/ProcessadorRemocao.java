package negocio;

import classes.ObjetoPersistivel;
import dao.GenericDAOImpl;
import dao.IGenericDAO;


/** Classe capaz de realizar remo��o de quaisquer entidades do sistema da base de dados.
 * @author Silv�rio Rodrigues
 * @since 13/12/2017
 */


public class ProcessadorRemocao extends ProcessadorComando {
	
	/** Objeto que se quer remover do banco. */
	protected ObjetoPersistivel obj;
	
	@Override
	protected void iniciarExecucao() throws Exception {
		IGenericDAO dao = new GenericDAOImpl();
		obj = dao.findByPrimaryKey(obj.getId(), obj.getClass());
		dao.delete(obj);
	}

	@Override
	protected Object getResultado() {
		return obj;
	}

	public void setObj(ObjetoPersistivel obj) {
		this.obj = obj;
	}

}
