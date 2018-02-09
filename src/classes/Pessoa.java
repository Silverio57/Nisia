package classes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;



/** Entidade que armazena os dados de uma pessoa no sistema.
 * @author Silvério Rodrigues
 * @since 22/12/2017
 */
@SuppressWarnings("serial")
@Entity
public class Pessoa implements ObjetoPersistivel {
	
	@Id
    @GeneratedValue  
	@Column(name="id_pessoa", nullable = false)
	private int id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	private String nomeagressor;
	
	@Column(nullable = false)
	private String telefone;

	@Column
	private String foto;
	
	/**Getters e Setters */
	
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNomeagressor() {
		return nomeagressor;
	}

	public void setNomeagressor(String nomeagressor) {
		this.nomeagressor = nomeagressor;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
