package br.unicesumar.escoladeti.comando;

import br.unicesumar.escoladeti.entity.Pessoa;
import br.unicesumar.escoladeti.entity.PessoaFisica;
import br.unicesumar.escoladeti.entity.PessoaJuridica;
import br.unicesumar.escoladeti.enums.Papel;
import br.unicesumar.escoladeti.enums.Sexo;
import br.unicesumar.escoladeti.util.string.StringUtils;
import java.util.Date;
import org.parboiled.common.Preconditions;

public class ComandoSalvarPessoa {

    private String nome;

    private String email;

    private String tipo;

    private String rg;

    private String cpf;

    private Date dataNascimento;

    private String sobrenome;

    private Sexo sexo;

    private Papel papel;

    private String cnpj;

    private String inscricaoEstadual;

    private String inscricaoMunicipal;

    private String razaoSocial;

    private Date dataCriacao;

    public ComandoSalvarPessoa() {

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

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
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

        private Papel papel;

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

        public PessoaBuilder papel(Papel papel) {
            this.papel = papel;
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

        public Pessoa build() {
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.nome));
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.email));
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.tipo));
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.rg));
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.cpf));
            Preconditions.checkNotNull(this.dataNascimento);
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.sobrenome));
            Preconditions.checkNotNull(this.sexo);
            Preconditions.checkNotNull(this.papel);
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.cnpj));
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.inscricaoEstadual));
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.inscricaoMunicipal));
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.razaoSocial));
            Preconditions.checkNotNull(this.dataCriacao);

            if (tipo.equals("F") ) {
                PessoaFisica pessoa = new PessoaFisica();
                pessoa.setNome(this.nome);
                pessoa.setEmail(this.email);
                pessoa.setRg(this.rg);
                pessoa.setCpf(this.cpf);
                pessoa.setDataNascimento(this.dataNascimento);
                pessoa.setSobrenome(this.sobrenome);
                pessoa.setSexo(this.sexo);
                pessoa.setPapel(this.papel);
                return pessoa;
            } else {
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
}
