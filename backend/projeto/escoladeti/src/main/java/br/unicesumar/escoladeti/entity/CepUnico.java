package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;

@Entity
public class CepUnico extends Entidade{
    private String cep;
    private String uf;
    private String cidade;

    public CepUnico() {
    }

    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
