package anotacoes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** Classe destinada para realização de testes.
 * @author João Paulo Nunes de Lima
 * @since 12 de dezembro de 2017
 */
@Entity
public class Testefoda {

	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
