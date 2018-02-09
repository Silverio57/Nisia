package controle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import arquitetura.ControleAbstrato;
import classes.Usuario;
import dao.UsuarioDAO;
import utilitarios.CriptografiaUtils;
import utilitarios.ValidatorUtil;
import classes.Pessoa;
import classes.TipoUsuario;



/** MBean que controla o login no sistema.
 * @author Silvério Rodrigues
 * @since 23/12/2017
 */ 
 
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class LoginMBean extends ControleAbstrato {
	
	/** Armazena os dados informados na tela de login. */
	private Usuario usuario;
	
	/** Armazena os dados iniciais de cadastro do usuário. */
	private Usuario usuarioCadastro;
	
	@PostConstruct
	private void init(){
		usuario = new Usuario();
		usuarioCadastro = new Usuario();
		usuarioCadastro.setPessoa(new Pessoa());
		usuarioCadastro.setTipoUsuario(TipoUsuario.COMUM);
	}
	
	/** Autentica o usuário e faz login no sistema. */
	/**
	 * @return
	 */
	public String autenticar(){
		if (!validarLogin()){
			
			System.out.println("nao foi");
			
			return null;
		}
		
		try {
			UsuarioDAO dao = new UsuarioDAO();
			usuario = dao.findUsuarioByLoginSenha(usuario.getEmail(), CriptografiaUtils.criptografarMD5(usuario.getSenha()));
			
			if (!ValidatorUtil.isEmpty(usuario)){
				if (!usuario.isAtivo()){
					addMsgError("Este usuário foi desabilitado e não possui mais acesso ao sistema.");
					return null;
				}
			} else {
				init();
				addMsgError("Usuário/Senha incorretos.");
				return null;
			}
			
			/** Verifica se os campos estao preenchidos conforme requisitado. */
			if((usuario.email == null)||(usuario.senha == null)||(usuario.senha.lenght < 5)){
				
				FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"É necessário preencher todos os campos obrigatórios", null);
					
				FacesContext.getCurrentInstance().addMessage(null, fm);
				return null;

			}
			
			return "confirmacao";
			
			/** Salva o usuário permanentemente na memória do sistema. */ 
			getCurrentSession().setAttribute("usuarioLogado", usuario);
			return Paginas.PORTAL_INICIO;
			
		} catch (Exception e) {
			tratamentoErroPadrao(e);
			return null;
		} 
	}
	
	/** Verifica se os dados para login estão corretos. */
	/**
	 * @return
	 */
	public boolean validarLogin(){
		if (usuario == null || (ValidatorUtil.isEmpty(usuario.getEmail()) && 
				ValidatorUtil.isEmpty(usuario.getSenha()))){
			addMsgError("Usuário/senha não informados.");
			return false;
		}
		
		if (ValidatorUtil.isEmpty(usuario.getEmail())){
			addMsgError("Usuário: campo obrigatório não informado.");
			return false;
		}
		
		if (ValidatorUtil.isEmpty(usuario.getSenha())){
			addMsgError("Senha: campo obrigatório não informado.");
			return false;
		}
		
		return true;
	}
	
	/** Realiza logoff do sistema. */
	/**
	 * @return
	 */
	public String logoff(){
		getCurrentSession().invalidate();
		return Paginas.LOGIN_PAGE;
	}
	
	/** Navega para a pagina de perfil. */
	/**
	 * @return
	 */
	public String navegarperfil(){
		if(getCurrentSession().setAttribute().equals("usuarioLogado")){
			return Paginas.PERFIL;
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

}