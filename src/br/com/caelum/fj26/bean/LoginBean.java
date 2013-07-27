package br.com.caelum.fj26.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caelum.fj26.dao.UsuarioDAO;

@ManagedBean
@SessionScoped
public class LoginBean {

	private Usuario usuario = new Usuario();
	
	public String login() {
		UsuarioDAO dao = new UsuarioDAO();
		boolean existe = dao.existe(usuario);
		if (existe) {
			return "produto?faces-redirect=true";
		}
		else {
			this.usuario = new Usuario();
			return "login";
		}
	}

	public String logout() {
		this.usuario = new Usuario();
		return "login?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogado() {
		return this.usuario.getLogin() != null;
	}
}
