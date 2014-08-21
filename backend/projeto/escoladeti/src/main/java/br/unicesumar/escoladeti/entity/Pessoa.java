package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.enums.Sexo;
import br.unicesumar.escoladeti.util.string.StringUtils;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import org.parboiled.common.Preconditions;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
public abstract class Pessoa extends Entidade {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;
    private String tipo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Telefone> telefones;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Endereco> enderecos;

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static PessoaBuilder builder() {
        return new PessoaBuilder();
    }

    public static class PessoaBuilder {

        private String nome;

        private String email;

        private String tipo;

        private String rg;

        private String cpf;

        private Date dataNascimento;

        private String sobrenome;

        private Sexo sexo;

        private boolean aluno;

        private String cnpj;

        private String inscricaoEstadual;

        private String inscricaoMunicipal;

        private String razaoSocial;

        private Date dataCriacao;

        public PessoaBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public PessoaBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PessoaBuilder tipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public PessoaBuilder rg(String rg) {
            this.rg = rg;
            return this;
        }

        public PessoaBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public PessoaBuilder dataNascimento(Date dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public PessoaBuilder sobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public PessoaBuilder sexo(Sexo sexo) {
            this.sexo = sexo;
            return this;
        }

        public PessoaBuilder aluno(boolean aluno) {
            this.aluno = aluno;
            return this;
        }

        public PessoaBuilder cnpj(String cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public PessoaBuilder inscricaoEstadual(String inscricaoEstadual) {
            this.inscricaoEstadual = inscricaoEstadual;
            return this;
        }

        public PessoaBuilder inscricaoMunicipal(String inscricaoMunicipal) {
            this.inscricaoMunicipal = inscricaoMunicipal;
            return this;
        }

        public PessoaBuilder razaoSocial(String razaoSocial) {
            this.razaoSocial = razaoSocial;
            return this;
        }

        public PessoaBuilder dataCriacao(Date dataCriacao) {
            this.dataCriacao = dataCriacao;
            return this;
        }

        public PessoaFisica buildPessoaFisica() {
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.nome),"Nome é obrigatório");
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.email),"Email é obrigatório");
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.tipo),"Tipo é obrigatório");

            Preconditions.checkNotNull(this.aluno);
            if (!this.aluno) {
                Preconditions.checkArgument(StringUtils.isNotEmpty(this.rg),"RG é obrigatório");
                Preconditions.checkArgument(StringUtils.isNotEmpty(this.cpf),"CPF é obrigatório");
            }
            Preconditions.checkNotNull(this.dataNascimento);
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.sobrenome),"Sobrenome é obrigatório");
            Preconditions.checkNotNull(this.sexo);

            PessoaFisica pessoa = new PessoaFisica();

            pessoa.setNome(this.nome);
            pessoa.setEmail(this.email);
            pessoa.setRg(this.rg);
            pessoa.setCpf(this.cpf);
            pessoa.setDataNascimento(this.dataNascimento);
            pessoa.setSobrenome(this.sobrenome);
            pessoa.setSexo(this.sexo);
            pessoa.setAluno(this.aluno);
            return pessoa;
        }

        public PessoaJuridica buildPessoaJuridica() {
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.nome),"Nome é obrigatório");
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.email),"Email é obrigatório");
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.cnpj),"CNPJ é obrigatório");
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.inscricaoEstadual),"Inscrição Estadual é obrigatório");
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.inscricaoMunicipal),"Inscrição Municipal é obrigatório");
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.razaoSocial),"Razão Social é obrigatório");
            Preconditions.checkNotNull(this.dataCriacao);

            PessoaJuridica pessoa = new PessoaJuridica();

            pessoa.setNome(this.nome);
            pessoa.setEmail(this.email);
            pessoa.setCnpj(this.cnpj);
            pessoa.setInscricaoEstadual(this.inscricaoEstadual);
            pessoa.setInscricaoMunicipal(this.inscricaoMunicipal);
            pessoa.setRazaoSocial(this.razaoSocial);
            pessoa.setDataCriacao(this.dataCriacao);
            return pessoa;
        }
    }
}
