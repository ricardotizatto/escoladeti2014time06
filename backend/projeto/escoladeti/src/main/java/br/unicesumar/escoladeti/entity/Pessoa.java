package br.unicesumar.escoladeti.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo")
public abstract class Pessoa extends Entidade {

    @NotNull
    @NotEmpty
    @Column
    private String nome;

    @NotNull
    @NotEmpty
    @Column
    private String email;
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "pessoa",cascade = CascadeType.ALL)
    @JsonManagedReference
    @IndexColumn(name = "id")
    private List<Telefone> telefones;  
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "pessoa",cascade = CascadeType.ALL)
    @JsonManagedReference
    @IndexColumn(name = "id")
    private List<Endereco> enderecos;
    
    public Pessoa(){
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
