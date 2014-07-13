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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Distrito extends Entidade {
	
	@Column(length = 100)
	@NotNull
	@NotEmpty
	private String nome;

    @Column(nullable = false)
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicioVigencia;
    
    @Column(nullable = false)
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fimVigencia;

    @ManyToOne
    @JoinColumn(name = "id_cidade", nullable = false)
    private Cidade cidade;
    
    public Distrito(){
    }
    public Distrito(Date inicioVigencia, Date fimVigencia, Cidade cidade, String nome){
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.cidade = cidade;
        this.nome = nome;
    }
    public Distrito(Long id, Date inicioVigencia, Date fimVigencia, Cidade cidade, String nome){
        this.id = id;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.cidade = cidade;
        this.nome = nome;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
