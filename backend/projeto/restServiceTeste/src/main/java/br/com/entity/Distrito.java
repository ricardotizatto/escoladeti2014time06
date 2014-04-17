package br.com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Distrito extends Entidade{
	@Column(nullable=false)
    private Date inicioVigencia;
	@Column(nullable=false)
    private Date fimVigencia;
	
	@OneToOne
	@JoinColumn(name="id_distrito", nullable=false)
	private Cidade distrito;
    
    @ManyToOne
    @JoinColumn(name="id_cidade", nullable =false)
    private Cidade cidadeSede;
    
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
        return cidadeSede;
    }

    public void setCidadeSede(Cidade cidadeSede) {
        this.cidadeSede = cidadeSede;
    }
}
