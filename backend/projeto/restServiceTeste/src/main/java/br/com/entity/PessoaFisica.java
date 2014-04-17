package br.com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Entidade{
<<<<<<< HEAD:backend/projeto/restService/src/main/java/br/com/entity/PessoaFisica.java
    @OneToOne(mappedBy = "pessoaFisica")
    @NotNull
    private Pessoa pessoa;
    
=======
	@Column(unique=true, nullable=false)
>>>>>>> e9f212b8d39f7febeff4fe68d7fbd4905e3d6080:backend/projeto/restServiceTeste/src/main/java/br/com/entity/PessoaFisica.java
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
