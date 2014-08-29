package br.unicesumar.escoladeti.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*
select t1.id, t1.cep, t4.id as paisid, t3.id as ufid, t2.id as cidadeid, t1.tipo, t1.logradouro, t1.bairro
*/
@Entity
public class BuscaCep implements Serializable{
    
    @Id
    private Long id;
    
    private String cep;
    
    @ManyToOne
    @JoinColumn(name = "cidadeid")
    private Cidade cidade;
    
    private String tipo;
    
    private String logradouro;
    
    private String bairro;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BuscaCep() {
    }
    
    
}
