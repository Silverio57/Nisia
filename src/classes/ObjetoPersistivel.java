package classes;

import java.io.Serializable;

/** Interface que deve ser implementada por todas as entidades do sistema.
 * @author João Paulo Nunes de lima
 * @since 22/12/2017
 */
public interface ObjetoPersistivel extends Serializable {

	/**
	 * @return
	 */
	public int getId();
	
	/**
	 * @param id
	 */
	public void setId(int id);
}

