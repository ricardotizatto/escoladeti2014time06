package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Usuario extends Entidade {
	
	@OneToOne
	@JoinColumn(name="id_usuario_perfil_acesso")
	private UsuarioPerfilAcesso usuarioPerfilDeAcesso;
	private String senha;
	private String login;
	private String nome;
	private String email;	

	public Usuario(UsuarioPerfilAcesso usuarioPerfilDeAcesso, String senha,
			String login, String nome, String email) {
		this.usuarioPerfilDeAcesso = usuarioPerfilDeAcesso;
		this.senha = senha;
		this.login = login;
		this.nome = nome;
		this.email = email;
	}

	public UsuarioPerfilAcesso getUsuarioPerfilDeAcesso() {
		return usuarioPerfilDeAcesso;
	}

	public void setUsuarioPerfilDeAcesso(
			UsuarioPerfilAcesso usuarioPerfilDeAcesso) {
		this.usuarioPerfilDeAcesso = usuarioPerfilDeAcesso;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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
