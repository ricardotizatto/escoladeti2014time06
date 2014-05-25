package br.unicesumar.escoladeti.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class PerfilAcesso extends Entidade {

    @Column(nullable = false)
    @NotEmpty
    private String nome;
    
//     @ManyToMany
//     @JoinTable(name = "perficalacesso_itemacesso", joinColumns = @JoinColumn(name = "id_perfilacesso", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_itemacesso", referencedColumnName = "id"))
//     private List<ItemAcesso> itemsAcesso;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "perfilAcesso",cascade = CascadeType.ALL)
    @JsonManagedReference
    @IndexColumn(name = "id")
    private List<UsuarioPerfilAcesso> usuarioPerfilsAcesso;

    public List<UsuarioPerfilAcesso> getUsuarioPerfilsAcesso() {
        return usuarioPerfilsAcesso;
    }

    public void setUsuarioPerfilsAcesso(List<UsuarioPerfilAcesso> usuarioPerfilsAcesso) {
        this.usuarioPerfilsAcesso = usuarioPerfilsAcesso;
    }
            
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
