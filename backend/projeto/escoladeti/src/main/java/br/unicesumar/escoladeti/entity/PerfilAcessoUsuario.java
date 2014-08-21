package br.unicesumar.escoladeti.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PerfilAcessoUsuario extends Entidade{
    
    @Temporal(TemporalType.DATE)
    private Date inicioVigencia;
    
    @Temporal(TemporalType.DATE)
    private Date fimVigencia;
    
    @ManyToOne
    @JoinColumn(name="id_perfilacesso", nullable = false)
    private PerfilAcesso perfilAcesso;
    
    @ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuario usuario;

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
    
}
