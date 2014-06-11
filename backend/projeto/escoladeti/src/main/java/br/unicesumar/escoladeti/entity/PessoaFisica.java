package br.unicesumar.escoladeti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.unicesumar.escoladeti.enums.Sexo;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue(value = "F")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@NotNull
    @NotEmpty
    private String rg;

    @NotEmpty
    @NotNull
    @Column(unique = true)
    private String cpf;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @NotNull
    @NotEmpty
    private String sobrenome;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public PessoaFisica() {
    }

    public PessoaFisica(String rg, String cpf, Date dataNascimento, String sobrenome) {
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobreNome) {
        this.sobrenome = sobreNome;
    }

    public Sexo getSexo() {
		return sexo;
	}
    
    public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
}
