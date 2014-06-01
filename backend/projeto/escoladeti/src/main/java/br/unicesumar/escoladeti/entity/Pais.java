package br.unicesumar.escoladeti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Pais extends Entidade {
	private static final long serialVersionUID = 1L;
	
	@NotNull
    @Column
    @NotEmpty
    private String nome;
	
	@NotNull
    @Column
    @NotEmpty
    private String sigla;
    
    @NotNull
    @Column
    private Integer codigo;

    public Pais() {

    }

    public Pais(Long id, String nome, String sigla, Integer codigo) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.codigo = codigo;
    }

    public Pais(String nome, String sigla, Integer codigo) {
        this.nome = nome;
        this.sigla = sigla;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
    
    public Integer getCodigo() {
		return codigo;
	}


}
