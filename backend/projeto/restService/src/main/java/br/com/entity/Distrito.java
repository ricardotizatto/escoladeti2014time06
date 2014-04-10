package br.com.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Distrito extends Entidade{
    private Date inicioVigencia;
    private Date fimVigencia;
    
    @ManyToOne
    private Cidade cidadeCede;
    
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

    public Cidade getCidadeCede() {
        return cidadeCede;
    }

    public void setCidadeCede(Cidade cidadeCede) {
        this.cidadeCede = cidadeCede;
    }
}
