package negocio;

import javax.persistence.EntityManager;

import dao.Database;




/**
 * Classe que representa um processador de dados. Deve ser estendido
 * por todos os outros processadores do sistema.
 * � esta class quem realiza opera��es cruciais do sistema, como
 * cadastro, edi��o, remo��o, etc.
 * @author Jo�o Paulo Nunes de lima
 * @since 13/12/2017
 */

public abstract class ProcessadorComando {
	
	/** M�todo principal que ir� iniciar a execu��o dos processamentos 
	 * dos processadores filhos. � o m�todo que deve ser chamado para 
	 * iniciar o processamento.
	 * @throws Exception 
	 * 
	 * @throws ArqException 
	 * @throws NegocioException 
	 */
	/**
	 * @return
	 * @throws Exception
	 */
	public final Object execute() throws Exception {
		EntityManager em = null;
		
		try {
			em = Database.getInstance().getEntityManager();
			
			em.getTransaction().begin();
			
			iniciarExecucao();
			
			em.getTransaction().commit();
			
			return getResultado();
			
		} catch (Exception e){
			e.printStackTrace();
			
			em = Database.getInstance().getEntityManager();
			
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			
			throw new Exception(e);
		} finally {
			/**Limpando caches
			if (em != null)
				em.clear();
			*/
		}
	}
	
	/** M�todo que os processadores filhos devem implementar para realizar as opera��es necess�rias. */
	protected abstract void iniciarExecucao() throws Exception;
	
	/** M�todo que deve ser implementado pelos processadores filhos para retornar algum dado
	 * para quem chamou o processador. 
	 */
	protected abstract Object getResultado();
	
}
