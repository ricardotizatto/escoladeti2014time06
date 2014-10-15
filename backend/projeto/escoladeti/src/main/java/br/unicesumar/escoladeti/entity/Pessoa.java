package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.comando.ComandoSalvarTelefone;
import br.unicesumar.escoladeti.enums.Sexo;
import br.unicesumar.escoladeti.util.data.DateUtil;
import br.unicesumar.escoladeti.util.string.StringUtils;
import br.unicesumar.escoladeti.util.validacao.Validar;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotEmpty;
import org.parboiled.common.Preconditions;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
public abstract class Pessoa extends Entidade {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;
    private String tipo;

    @NotEmpty(message = "Deve ser cadastrado ao menos um Telefone!")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "pessoa")
    private Set<Telefone> telefones;

    @NotEmpty(message = "Deve ser cadastrado ao menos um Endereço!")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Endereco> enderecos;
    
    @ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER, targetEntity = Caracteristica.class)
    @JoinTable(name = "pessoacaracteristica",joinColumns = @JoinColumn(name = "pessoaid"),
    			inverseJoinColumns = @JoinColumn(name = "caracteristicaid",updatable = true))
    @JsonManagedReference
    private Set<Caracteristica> caracteristicas = new HashSet<Caracteristica>();

    public Pessoa() {
        this.telefones = new HashSet<Telefone>();
        this.enderecos = new HashSet<Endereco>();
        this.caracteristicas = new HashSet<Caracteristica>();
    }
    
    public Set<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(Set<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}


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
        this.nome = nome.toUpperCase();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toUpperCase();
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

        private Set<Telefone> telefones;

        private Set<Endereco> enderecos;
        
        private Set<Caracteristica> caracteristicas;
        
        public PessoaBuilder caracteristicas(Set<Caracteristica> caracteristicas){
        	this.caracteristicas = caracteristicas;
        	return this;
        }

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

        public PessoaBuilder telefones(Set<Telefone> telefones) {
            this.telefones = telefones;
            return this;
        }

        public PessoaBuilder enderecos(Set<Endereco> enderecos) {
            this.enderecos = enderecos;
            return this;
        }

        public PessoaFisica buildPessoaFisica() {
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.nome), "Nome é obrigatório");
            if (!StringUtils.onlyLetters(this.nome)) {
                throw new RuntimeException("Nome inválido");
            }
            if (this.email != "") {
                Preconditions.checkArgument(Validar.validaEmail(this.email), "Email inválido!");
            }
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.tipo), "Tipo é obrigatório");

            Preconditions.checkNotNull(this.aluno);
            if (!this.aluno) {
                Preconditions.checkArgument(StringUtils.isNotEmpty(this.rg), "RG é obrigatório");
                Preconditions.checkArgument(StringUtils.isNotEmpty(this.cpf), "CPF é obrigatório");
            }
            Preconditions.checkNotNull(this.dataNascimento, "Data é obrigatória");
            if (DateUtil.validDate(this.dataNascimento)) {
                throw new RuntimeException("Data inválida");
            }

            Preconditions.checkArgument(StringUtils.isNotEmpty(this.sobrenome), "Sobrenome é obrigatório");
            if (!StringUtils.onlyLetters(this.sobrenome)) {
                throw new RuntimeException("Sobrenome inválido");
            }
            Preconditions.checkNotNull(this.sexo);

            PessoaFisica pessoa = new PessoaFisica();

            pessoa.setTipo(this.tipo);
            pessoa.setNome(this.nome);
            pessoa.setEmail(this.email);
            pessoa.setRg(this.rg);
            pessoa.setCpf(this.cpf);
            pessoa.setDataNascimento(this.dataNascimento);
            pessoa.setSobrenome(this.sobrenome);
            pessoa.setSexo(this.sexo);
            pessoa.setAluno(this.aluno);
            pessoa.setTelefones(this.telefones);
            pessoa.setEnderecos(this.enderecos);
            pessoa.setCaracteristicas(this.caracteristicas);
            for (Telefone telefone : pessoa.getTelefones()) {
                telefone.setPessoa(pessoa);
            }
            for (Endereco end : pessoa.getEnderecos()) {
                end.setPessoa(pessoa);
            }
            return pessoa;
        }

        public PessoaJuridica buildPessoaJuridica() {
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.nome), "Nome é obrigatório");
            if (this.email != "") {
                Preconditions.checkArgument(Validar.validaEmail(this.email), "Email inválido!");
            }
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.cnpj), "CNPJ é obrigatório");
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.tipo), "Tipo é obrigatório");
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.inscricaoMunicipal), "Inscrição Municipal é obrigatório");
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.razaoSocial), "Razão Social é obrigatório");
            if (this.dataCriacao != null) {
                if (DateUtil.validDate(this.dataCriacao)) {
                    throw new RuntimeException("Data inválida");
                }
            }

            PessoaJuridica pessoa = new PessoaJuridica();

            pessoa.setTipo(this.tipo);
            pessoa.setNome(this.nome);
            pessoa.setEmail(this.email);
            pessoa.setCnpj(this.cnpj);
            pessoa.setInscricaoEstadual(this.inscricaoEstadual);
            pessoa.setInscricaoMunicipal(this.inscricaoMunicipal);
            pessoa.setRazaoSocial(this.razaoSocial);
            pessoa.setDataCriacao(this.dataCriacao);
            pessoa.setTelefones(this.telefones);
            pessoa.setEnderecos(this.enderecos);
            for (Telefone telefone : pessoa.getTelefones()) {
                telefone.setPessoa(pessoa);
            }
            for (Endereco end : pessoa.getEnderecos()) {
                end.setPessoa(pessoa);
            }
            return pessoa;

        }

        public PessoaBuilder adicionarTelefones(
                Set<ComandoSalvarTelefone> telefone) {
            return null;
        }
    }
}
