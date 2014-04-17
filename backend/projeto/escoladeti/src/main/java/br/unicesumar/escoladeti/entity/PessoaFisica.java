package br.unicesumar.escoladeti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Entidade{
	@Column(unique=true, nullable=false)
    private String rg;
	@Column(unique=true, nullable=false)
    private String cpf;
    private Date dataNascimento;
    @Column(nullable=false)
    private String sobreNome;

    public PessoaFisica(String rg, String cpf, Date dataNascimento, String sobreNome) {
		this.rg = rg;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.sobreNome = sobreNome;
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

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }
}
