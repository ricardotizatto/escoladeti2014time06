package br.com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class FaixaCep extends Entidade {
    private String inicioCep;
    private String fimCep;
    
    @ManyToMany
    @JoinTable(name="bairro_faixacep", joinColumns=@JoinColumn(name="id_faixaCep"),
    		inverseJoinColumns=@JoinColumn(name="id_bairro"))
    private List<Bairro> bairro;
    
    public String getInicioCep() {
        return inicioCep;
    }

    public void setInicioCep(String inicioCep) {
        this.inicioCep = inicioCep;
    }

    public String getFimCep() {
        return fimCep;
    }

    public void setFimCep(String fimCep) {
        this.fimCep = fimCep;
    }

}
