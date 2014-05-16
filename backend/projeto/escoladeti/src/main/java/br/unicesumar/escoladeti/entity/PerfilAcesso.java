package br.unicesumar.escoladeti.entity;

import java.util.List;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class PerfilAcesso extends Entidade {

    @Column(nullable = false)
    @NotEmpty
    private String nome;

    /*
     @ManyToMany
     @JoinTable(name = "perficalacesso_itemacesso", joinColumns = @JoinColumn(name = "id_perfilacesso", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_itemacesso", referencedColumnName = "id"))
     private List<ItemAcesso> itemsAcesso;
     */
    
    public PerfilAcesso(){
    }
    
    public PerfilAcesso(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
