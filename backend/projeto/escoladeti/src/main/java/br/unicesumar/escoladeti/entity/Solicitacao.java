package br.unicesumar.escoladeti.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Solicitacao extends Entidade {

    private static final long serialVersionUID = 1L;
    
    @NotNull(message="Aluno é obrigatorio")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_aluno")
    private PessoaFisica aluno;
    
    private String escola;
    
    @ManyToOne
    @JoinColumn(name="id_cidadenre")
    private Cidade nre;
    
    @ManyToOne
    @JoinColumn(name="id_municipio")
    private Cidade municipio;
    
    private String cep;    
    
    private String endereco;
    
    @Min(value=0, message="Informe um endereço válido")
    @Max(value=9999, message="Informe um endereço válido")
    private Integer numeroEndereco;
    
    private String serie;
    
    private String ensino;
    
    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private PessoaFisica responsavel;

    @NotEmpty(message="Devem ser inseridos materiais que serão produzidos")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER, mappedBy="solicitacao")
//    @JoinColumn(name = "id_solicitacao", insertable=true, updatable=true)
    private List<SolicitacaoItem> itensSolicitacao;

    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataChegada;

    public Solicitacao() {
    	this.itensSolicitacao = new ArrayList<SolicitacaoItem>();
    }

    public Solicitacao(PessoaFisica responsavel, Date dataChegada) {
    	this();
        this.responsavel = responsavel;
        this.dataChegada = dataChegada;
    }

    public void setNre(Cidade nre) {
        this.nre = nre;
    }

    public Cidade getNre() {
        return nre;
    }


	public PessoaFisica getAluno() {
		return aluno;
	}

	public void setAluno(PessoaFisica aluno) {
		this.aluno = aluno;
	}

	public Cidade getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Cidade municipio) {
		this.municipio = municipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	
	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(Integer numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getEnsino() {
		return ensino;
	}

	public void setEnsino(String ensino) {
		this.ensino = ensino;
	}

	public PessoaFisica getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(PessoaFisica responsavel) {
		this.responsavel = responsavel;
	}

	public List<SolicitacaoItem> getItensSolicitacao() {
		return itensSolicitacao;
	}

	public void setItensSolicitacao(List<SolicitacaoItem> itensSolicitacao) {
		this.itensSolicitacao = itensSolicitacao;
	}

	public Date getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}

    
	public String getEscola() {
		return escola;
	}
	
	
	public void setEscola(String escola) {
		this.escola = escola;
	}
}
