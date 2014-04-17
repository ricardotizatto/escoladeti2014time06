package br.com.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity 
<<<<<<< HEAD:backend/projeto/restService/src/main/java/br/com/entity/Pessoa.java
public class Pessoa extends Entidade {
=======
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa extends Entidade {
	@NotNull
>>>>>>> e9f212b8d39f7febeff4fe68d7fbd4905e3d6080:backend/projeto/restServiceTeste/src/main/java/br/com/entity/Pessoa.java
    private String nome;
    private String email;
    
    @OneToOne
    private PessoaJuridica pessoaJuridica;
    
    @OneToOne
    private PessoaFisica pessoaFisica;

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

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }
}
