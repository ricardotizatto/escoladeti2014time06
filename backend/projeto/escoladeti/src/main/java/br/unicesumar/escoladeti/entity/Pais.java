package br.unicesumar.escoladeti.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class Pais extends Entidade {
	

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column
    @NotEmpty
    private String nome;
	

    @NotNull
    @Column
    @NotEmpty
    private String sigla;

    @NotNull
    @Column   
    private String codigo;

    public Pais() {

    }
  
    
    public Pais(Long id, String nome, String sigla, String codigo) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.codigo = codigo;
    }

    public Pais(String nome, String sigla, String codigo) {
        this.nome = nome;
        this.sigla = sigla;
        this.codigo = codigo;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla.toUpperCase();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.sigla);
        hash = 37 * hash + Objects.hashCode(this.codigo);
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
        final Pais other = (Pais) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sigla, other.sigla)) {
            return false;
        }
        return true;
    }
       
   }
