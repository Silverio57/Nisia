package negocio;

import classes.ObjetoPersistivel;
import dao.GenericDAOImpl;
import dao.IGenericDAO;

/** 
 * Classe capaz de realizar inativa��o/ativa��o l�gica de quaisquer entidades do sistema
 * que possuam um atributo chamado "ativo".
 * @author Jo�o Paulo Nunes de lima
 * @since 13/12/2017
 */
public class ProcessadorInativar extends ProcessadorComando {
	
	public static final int INATIVAR = 1;
	public static final int REATIVAR = 2;
	
	/** Indica a opera��o a ser realizada. Deve ser INATIVAR ou ser REATIVAR. */
	private int operacao;
	
	/**  Objeto que se quer inativar/reativar no banco. */
	private ObjetoPersistivel obj;
	
	/** (non-Javadoc)
	 * @see negocio.ProcessadorComando#iniciarExecucao()
	 */
	@Override
	protected void iniciarExecucao() throws Exception {
		IGenericDAO dao = new GenericDAOImpl();
		
		if (operacao == INATIVAR)
			/** Atualiza a coluna "ativo" do objeto em quest�o */
			dao.updateField(obj.getClass(), obj.getId(), "ativo", false);
		else if (operacao == REATIVAR)
			/** Atualiza a coluna "ativo" do objeto em quest�o. */
			dao.updateField(obj.getClass(), obj.getId(), "ativo", true);
		else
			throw new Exception("Opera��o inv�lida!");
		
		dao.detach(obj);
	}

	@Override
	protected Object getResultado() {
		return obj;
	}

	public void setObj(ObjetoPersistivel obj) {
		this.obj = obj;
	}

	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}
	
}
