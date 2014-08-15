package br.unicesumar.escoladeti.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class UsuarioPerfilAcesso extends Entidade {

    @Temporal(value = TemporalType.DATE)
    private Date inicioVigencia;

    @Temporal(value = TemporalType.DATE)
    private Date fimVigencia;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    @JsonManagedReference
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_perfil_acesso")
    @JsonIgnore
    @JsonManagedReference
    private PerfilAcesso perfilAcesso;

    public UsuarioPerfilAcesso() {
    }

    public UsuarioPerfilAcesso(Date inicioVigencia, Date fimVigencia, Usuario usuario) {
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.usuario = usuario;
    }

    public PerfilAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
