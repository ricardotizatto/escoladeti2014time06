package br.unicesumar.escoladeti.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco extends Entidade {

    @NotNull
    private String cep;

    @NotNull
    private int numero;

    private String complemento;

    @NotNull
    private boolean principal;

//    @Embedded
//    private Logradouro logradouro;

//    @ManyToOne
//    @JoinColumn(name = "id_bairro")
//    @JsonBackReference
//    private Bairro bairro;

    @ManyToOne
    @JoinColumn(name="id_pessoa",referencedColumnName = "id")
    @JsonBackReference
    private Pessoa pessoa;

    public Endereco() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

//    public Logradouro getLogradouro() {
//        return logradouro;
//    }
//
//    public void setLogradouro(Logradouro logradouro) {
//        this.logradouro = logradouro;
//    }

//    public Bairro getBairro() {
//        return bairro;
//    }
//
//    public void setBairro(Bairro bairro) {
//        this.bairro = bairro;
//    }
}
