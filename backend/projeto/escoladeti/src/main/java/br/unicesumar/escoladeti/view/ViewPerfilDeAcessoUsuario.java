package br.unicesumar.escoladeti.view;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity(name = "viewperfildeacessousuario")
public class ViewPerfilDeAcessoUsuario implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private boolean ativo;
    private String email;
    private String login;
    private String nome;
    private Long perfildeacessousuarioid;
    @Temporal(TemporalType.DATE)
    private Date fimVigencia;
    @Temporal(TemporalType.DATE)
    private Date inicioVigencia;
    private String perfilAcessoId;
    private String perfil;
    
    public ViewPerfilDeAcessoUsuario(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getPerfilDeAcessoUsuarioId() {
        return perfildeacessousuarioid;
    }

    public void setPerfilDeAcessoUsuarioId(Long perfildeacessousuarioid) {
        this.perfildeacessousuarioid = perfildeacessousuarioid;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Date fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public String getPerfilAcessoId() {
        return perfilAcessoId;
    }

    public void setPerfilAcessoId(String perfilAcessoId) {
        this.perfilAcessoId = perfilAcessoId;
    }   
    
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
