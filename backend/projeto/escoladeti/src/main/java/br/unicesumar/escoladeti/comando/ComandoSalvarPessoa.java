package br.unicesumar.escoladeti.comando;

import br.unicesumar.escoladeti.entity.Endereco;
import br.unicesumar.escoladeti.entity.Telefone;
import br.unicesumar.escoladeti.enums.Sexo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComandoSalvarPessoa {

    private String nome;
    private String email;
    private String tipo;
    private String rg;
    private String cpf;
    private Date dataNascimento;
    private String sobrenome;
    private Sexo sexo;
    private String cnpj;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private String razaoSocial;
    private Date dataCriacao;
    private Set<Telefone> telefones;
    private Set<Endereco> enderecos;
    private List<Long> caracteristicas;
    private Date vigenciaAssociado;
    
	public Date getVigenciaAssociado() {
		return vigenciaAssociado;
	}

	public void setVigenciaAssociado(Date vigenciaAssociado) {
		this.vigenciaAssociado = vigenciaAssociado;
	}

	public List<Long> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<Long> caracteristicas) {
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
    
}
