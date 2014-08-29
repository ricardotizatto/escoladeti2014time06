package br.unicesumar.escoladeti.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.unicesumar.escoladeti.enums.Sexo;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue(value = "F")
public class PessoaFisica extends Pessoa {

    private static final long serialVersionUID = 1L;

    private String rg;

    private String cpf;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    private String sobrenome;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private boolean aluno = false;

    public PessoaFisica() {
    }

    public PessoaFisica(String rg, String cpf, Date dataNascimento, String sobrenome) {
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sobrenome = sobrenome;
    }

    public PessoaFisica(Long id) {
        this.id = id;
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

    public boolean getAluno() {
        return aluno;
    }

    public void setAluno(boolean aluno) {
        this.aluno = aluno;
    }

    public static PessoaFisica of(Long id) {
        return new PessoaFisica(id);
    }
}
