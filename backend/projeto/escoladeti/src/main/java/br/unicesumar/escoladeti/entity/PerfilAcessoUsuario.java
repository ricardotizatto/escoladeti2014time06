package br.unicesumar.escoladeti.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PerfilAcessoUsuario extends Entidade {

    private static final long serialVersionUID = 1L;
    
    @Temporal(TemporalType.DATE)
    private Date inicioVigencia;
    
    @Temporal(TemporalType.DATE)
    private Date fimVigencia;
    
    @ManyToOne
    @JoinColumn(name = "id_perfilacesso", referencedColumnName = "id")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "perfilacessousuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private PerfilAcesso perfilAcesso;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "perfilacessousuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Usuario usuario;
    
    public PerfilAcessoUsuario(Long id, Date inicioVigencia, Date fimVigencia, PerfilAcesso perfilAcesso, Usuario usuario) {
        this.id = id;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.perfilAcesso = perfilAcesso;
        this.usuario = usuario;
    }

    public PerfilAcessoUsuario(Date inicioVigencia, Date fimVigencia, PerfilAcesso perfilAcesso, Usuario usuario) {
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.perfilAcesso = perfilAcesso;
        this.usuario = usuario;
    }

    public PerfilAcessoUsuario() {
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

    public PerfilAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
