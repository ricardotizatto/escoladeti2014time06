package br.unicesumar.escoladeti.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cep extends Entidade {
    
    private String cidade;
    private String logradouro;
    private String bairro;
    private String cep;
    private String tipo;
    private String uf;

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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.cidade);
        hash = 43 * hash + Objects.hashCode(this.logradouro);
        hash = 43 * hash + Objects.hashCode(this.bairro);
        hash = 43 * hash + Objects.hashCode(this.cep);
        hash = 43 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cep other = (Cep) obj;
        return true;
    }
}
