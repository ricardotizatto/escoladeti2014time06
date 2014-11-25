package br.unicesumar.escoladeti.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class PerfilAcesso {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "perfilAcesso", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PerfilItemAcesso> itens = new HashSet<>();
    
    private String nome;

    public PerfilAcesso() {
    }
    
    public PerfilAcesso(Long id) {
        this.id = id;
    }
    
    public PerfilAcesso(Long id, String nome) {
        this.id = id;
        this.nome = nome.toUpperCase();
    }

    public Set<PerfilItemAcesso> getItens() {
        return itens;
    }

    public void setItens(Set<PerfilItemAcesso> itens) {
        this.itens = itens;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void adcionarItem(Long idItemAcesso) {
        PerfilItemAcesso perfilItemAcesso = new PerfilItemAcesso();
        perfilItemAcesso.setPerfilAcesso(this);
        perfilItemAcesso.setIdItemAcesso(idItemAcesso);
        itens.add(perfilItemAcesso);
    }
}