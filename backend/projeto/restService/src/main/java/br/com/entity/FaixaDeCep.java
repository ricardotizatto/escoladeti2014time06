package br.com.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class FaixaDeCep extends Entidade{
    private String inicioCep;
    private String fimCep;
    
    @OneToMany(mappedBy = "faixaDeCep")
    @NotNull
    private List<Bairro> bairros;
    
    @OneToMany(mappedBy = "faixaDeCep")
    @NotNull
    private List<Logradouro> logradouros;

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

    public List<Bairro> getBairros() {
        return bairros;
    }

    public void setBairros(List<Bairro> bairros) {
        this.bairros = bairros;
    }

    public List<Logradouro> getLogradouros() {
        return logradouros;
    }

    public void setLogradouros(List<Logradouro> logradouros) {
        this.logradouros = logradouros;
    }

}
