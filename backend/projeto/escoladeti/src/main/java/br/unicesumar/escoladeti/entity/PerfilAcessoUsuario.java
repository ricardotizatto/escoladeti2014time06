package br.unicesumar.escoladeti.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PerfilAcessoUsuario extends Entidade{
    
    private Date inicioVigencia;
    private Date fimVigencia;
    
    @ManyToOne
    @JoinColumn(name="id_perfilacesso", nullable = false)
    private PerfilAcesso perfilAcesso;

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
