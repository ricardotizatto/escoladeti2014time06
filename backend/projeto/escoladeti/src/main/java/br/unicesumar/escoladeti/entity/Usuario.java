package br.unicesumar.escoladeti.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import static liquibase.util.MD5Util.computeMD5;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario extends Entidade {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String login;

    @NotNull
    @NotEmpty
    private String senha;

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    private Boolean ativo;

    @OneToOne(mappedBy = "usuario",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private UsuarioPerfilAcesso usuarioPerfilAcesso;

    public Usuario() {
    }

    public Usuario(String nome, String senha, String login, String email) {
        this.login = login;
        this.nome = nome;
        this.email = email;
        setSenha(senha);
    }

    public UsuarioPerfilAcesso getUsuarioPerfilAcesso() {
        return usuarioPerfilAcesso;
    }

    public void setUsuarioPerfilAcesso(UsuarioPerfilAcesso usuarioPerfilAcesso) {
        this.usuarioPerfilAcesso = usuarioPerfilAcesso;
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

}
