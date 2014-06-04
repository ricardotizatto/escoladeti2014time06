package br.unicesumar.escoladeti.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
public class Distrito extends Entidade {

    @Column(nullable = false)
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicioVigencia;
    
    @Column(nullable = false)
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fimVigencia;

    @OneToOne
    @JoinColumn(name = "id_distrito", nullable = false)
    private Cidade distrito;

    @ManyToOne
    @JoinColumn(name = "id_cidade", nullable = false)
    private Cidade municipio;
    
    public Distrito(){
    }
    public Distrito(Date inicioVigencia, Date fimVigencia, Cidade distrito, Cidade municipio){
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.distrito = distrito;
        this.municipio = municipio;
    }
    public Distrito(Long id, Date inicioVigencia, Date fimVigencia, Cidade distrito, Cidade municipio){
        this.id = id;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.distrito = distrito;
        this.municipio = municipio;
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

    public Cidade getCidadeSede() {
        return municipio;
    }

    public void setCidadeSede(Cidade municipio) {
        this.municipio = municipio;
    }
}
