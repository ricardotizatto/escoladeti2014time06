package br.unicesumar.escoladeti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Participante extends Entidade{  
    @NotNull
    @NotEmpty
    @Column
    private String nome;
    @NotNull
    @NotEmpty
    @Column
    private String cpf;
    private String rg;
    
}