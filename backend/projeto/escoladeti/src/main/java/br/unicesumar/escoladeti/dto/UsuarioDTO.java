package br.unicesumar.escoladeti.dto;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class UsuarioDTO {
    
    private Long id;
    private Long perfilDeAcessoUsuarioId;

    private boolean ativo;
    private String nome;
    private String login;
    private String senha;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date inicioVigencia;
    @Temporal(TemporalType.DATE)
    private Date fimVigencia;
    private Long perfilAcessoId;
    private String perfil;
   
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getPerfilDeAcessoUsuarioId() {
        return perfilDeAcessoUsuarioId;
    }

    public void setPerfilDeAcessoUsuarioId(Long perfilDeAcessoUsuarioId) {
        this.perfilDeAcessoUsuarioId = perfilDeAcessoUsuarioId;
    }
    
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
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

    public boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Date fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public Long getPerfilAcessoId() {
        return perfilAcessoId;
    }

    public void setPerfilAcessoId(Long perfilAcessoId) {
        this.perfilAcessoId = perfilAcessoId;
    }
    
    public String getPerfil() {
        return perfil;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
}
