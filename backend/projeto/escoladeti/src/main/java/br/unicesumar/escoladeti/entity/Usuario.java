package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import static liquibase.util.MD5Util.computeMD5;

@Entity
public class Usuario extends Entidade {

    private String nome;
    private String login;
    private String senha;
    private String email;
    private Boolean ativo;
    
    @ManyToOne
    @JoinColumn(name = "perfilacessousuarioid", nullable = false)
    private PerfilAcessoUsuario perfilAcessoUsuario;

    public Usuario() {
    }

    public Usuario(String nome, String senha, String login, String email) {
        this.login = login;
        this.nome = nome;
        this.email = email;
        setSenha(senha);
    }

    private Usuario(Long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = computeMD5(senha);
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    public PerfilAcessoUsuario getPerfilAcessoUsuario() {
        return perfilAcessoUsuario;
    }

    public void setPerfilAcessoUsuario(PerfilAcessoUsuario perfilAcessoUsuario) {
        this.perfilAcessoUsuario = perfilAcessoUsuario;
    }

    public static Usuario of(Long id) {
        return new Usuario(id);
    }
}
