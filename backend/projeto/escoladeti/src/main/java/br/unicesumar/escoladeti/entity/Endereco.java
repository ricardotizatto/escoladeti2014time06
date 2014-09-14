package br.unicesumar.escoladeti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.unicesumar.escoladeti.enums.TipoEndereco;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Endereco extends Entidade {

    @Column(length = 10)
    @NotNull
    @NotEmpty
    private String cep;

    @Column(length = 10)
    @NotNull
    private int numero;

    @NotNull
    private String logradouro;

    @NotNull
    private String bairro;

    @Column(length = 100)
    private String complemento;

    @NotNull
    private char principal;

//    @Embedded
//    private Logradouro logradouro;
//    @ManyToOne
//    @JoinColumn(name = "id_bairro")
//    @JsonBackReference
//    private Bairro bairro;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipoendereco")
    private TipoEndereco tipo;

    @ManyToOne
    @JoinColumn(name = "pessoaid", referencedColumnName = "id")
    @JsonBackReference
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "cidadeid", nullable = false)
    private Cidade cidade;

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(TipoEndereco tipoEndereco) {
        this.tipo = tipoEndereco;
    }

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

    public char getPrincipal() {
        return principal;
    }

    public void setPrincipal(char principal) {
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
