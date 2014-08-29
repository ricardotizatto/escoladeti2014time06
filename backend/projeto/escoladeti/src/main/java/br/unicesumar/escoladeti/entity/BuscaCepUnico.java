package br.unicesumar.escoladeti.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BuscaCepUnico implements Serializable {

    @Id
    private Long id;

    private String cep;

    @ManyToOne
    @JoinColumn(name = "cidadeid")
    private Cidade cidade;

    public BuscaCepUnico() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    
    

}
