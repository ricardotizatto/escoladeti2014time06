package br.unicesumar.escoladeti.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Telefone extends Entidade {

    @NotNull
    private Integer ddd;

    @NotNull
    private Integer numero;

    @NotNull
    private Integer tipo;
    
    @JsonUnwrapped
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa")
    
    private Pessoa pessoa;
    
    public Telefone(){
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @JsonUnwrapped
    public Pessoa getPessoa() {
        return pessoa;
    }

    @JsonUnwrapped
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

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
