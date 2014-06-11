package br.unicesumar.escoladeti.entity;

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

    private Integer ddd;

    @NotNull
    private Integer numero;
    
    
    private Integer ramal;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;
    
    @ManyToOne
    @JoinColumn(name = "id_pessoa",referencedColumnName = "id")
    @JsonBackReference
    private Pessoa pessoa;
    
    public Telefone(){
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
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

    public Integer getTelefone() {
        return numero;
    }

    public void setTelefone(Integer telefone) {
        this.numero = telefone;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }
}
