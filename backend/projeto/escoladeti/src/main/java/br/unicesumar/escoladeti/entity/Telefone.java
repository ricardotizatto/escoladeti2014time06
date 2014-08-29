package br.unicesumar.escoladeti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.unicesumar.escoladeti.enums.TipoTelefone;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Telefone extends Entidade {

    private static final long serialVersionUID = 1L;

    @Column(length = 2)
    @NotNull
    private Integer ddd;

    @NotNull
    @Column(length = 10)
    private String numero;
    
    @Column(length = 10)
    private Integer ramal;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;
    
//    @JoinColumn(name = "id_pessoa",referencedColumnName = "id")
    
    @ManyToOne
    @JoinColumn(name="pessoaid",referencedColumnName = "id")
    @JsonBackReference
    private Pessoa pessoa;
    
    public Telefone(){
    	setDdd(0);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }
    
    public void setRamal(Integer ramal) {
		this.ramal = ramal;
	}
    
    public Integer getRamal() {
		return ramal;
	}
}
