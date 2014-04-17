package br.com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario extends Entidade {
	
	@OneToOne
	private UsuarioPerfilAcesso usuarioPerfilDeAcesso;
	private String senha;
	private String login;
	private String nome;
	private String email;
	
	@OneToMany(mappedBy = "usuario")
	private List<ItemDeAcessoUsuario> itensDeAcesso;

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
