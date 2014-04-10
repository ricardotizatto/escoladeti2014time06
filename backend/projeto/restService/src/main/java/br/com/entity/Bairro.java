package br.com.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Bairro extends Entidade {
    private String nome;
    
    @ManyToOne
    private Cidade cidade;
    
    @ManyToOne
    private FaixaDeCep faixaDeCep;
    
    @OneToMany(mappedBy = "bairro")
    @NotNull
    private List<Endereco> enderecos;

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    public FaixaDeCep getFaixaDeCep() {
        return faixaDeCep;
    }

    public void setFaixaDeCep(FaixaDeCep faixaDeCep) {
        this.faixaDeCep = faixaDeCep;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
