package br.unicesumar.escoladeti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import static liquibase.util.MD5Util.computeMD5;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario extends Entidade {

    @OneToOne
    @JoinColumn(name = "id_usuario_perfil_acesso")
    private UsuarioPerfilAcesso usuarioPerfilDeAcesso;

    @Column(nullable = false)
    @NotEmpty
    private String senha;

    @Column(nullable = false)
    @NotEmpty
    private String login;

    @Column(nullable = false)
    @NotEmpty
    private String nome;

    @Column(nullable = false)
    @NotEmpty
    private String email;

    @Column(nullable = false)
    @NotEmpty
    private Boolean ativo;

    public Usuario() {
    }

    public Usuario(String nome, String senha, String login, String email) {
        this.login = login;
        this.nome = nome;
        this.email = email;        
        setSenha(senha);
    }

    public UsuarioPerfilAcesso getUsuarioPerfilDeAcesso() {
        return usuarioPerfilDeAcesso;
    }

    public void setUsuarioPerfilDeAcesso(UsuarioPerfilAcesso usuarioPerfilDeAcesso) {
        this.usuarioPerfilDeAcesso = usuarioPerfilDeAcesso;
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
