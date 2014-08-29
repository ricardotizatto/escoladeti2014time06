package br.unicesumar.escoladeti.entity;

import static org.parboiled.common.Preconditions.checkNotNull;
import static org.parboiled.common.Preconditions.checkArgument;

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

import br.unicesumar.escoladeti.comando.ComandoSalvarSolicitacaoItem;
import br.unicesumar.escoladeti.entity.Solicitacao.SolicitacaoBuilder;

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

	public static SolicitacaoBuilder builder() {
		return new SolicitacaoBuilder();
	}
	
	public static class SolicitacaoBuilder {
	    private Long aluno;
	    
	    private String escola;
	    
	    private Long nre;
	    
	    private Long municipio;
	    
	    private String cep;    
	    
	    private String endereco;
	    
	    private Integer numeroEndereco;
	    
	    private String serie;
	    
	    private String ensino;
	    
	    private Long responsavel;

	    private List<SolicitacaoItem> itensSolicitacao;

	    private Date dataChegada;

	    private Long id;
	    
	    private SolicitacaoBuilder() {
	    	
	    }
	    
	    public Solicitacao.SolicitacaoBuilder ensino(String ensino) {
			this.ensino = ensino;
			return this;
		}
	    
	    public SolicitacaoBuilder nre(Long nre) {
			this.nre = nre;
			return this;
		}
	    
	    public SolicitacaoBuilder itensSolicitacao(List<SolicitacaoItem> itensSolicitacao) {
			this.itensSolicitacao = itensSolicitacao;
			return this;
		}
	    
	    public SolicitacaoBuilder cep(String cep) {
			this.cep = cep;
			return this;
		}
	    
	    public SolicitacaoBuilder municipio(Long municipio) {
			this.municipio = municipio;
			return this;
		}
	    
	    public SolicitacaoBuilder numeroEndereco(Integer numeroEndereco) {
			this.numeroEndereco = numeroEndereco;
			return this;
		}
	    
	    public SolicitacaoBuilder escola(String escola) {
			this.escola = escola;
			return this;
		}
	    
	    public SolicitacaoBuilder responsavel(Long responsavel) {
			this.responsavel = responsavel;
			return this;
		}
	    
	    public SolicitacaoBuilder dataChegada(Date dataChegada) {
			this.dataChegada = dataChegada;
			return this;
		}
	    
	    public SolicitacaoBuilder serie(String serie) {
			this.serie = serie;
			return this;
		}
	    
	    
	    public SolicitacaoBuilder aluno(Long aluno) {
			this.aluno = aluno;
			return this;
		}
	    
	    public SolicitacaoBuilder endereco(String endereco) {
			this.endereco = endereco;
			return this;
		}
	    
	    public Solicitacao build() {
	    	checkNotNull(this.aluno, "Aluno é obrigatório");
	    	checkNotNull(this.dataChegada, "Data chegada é obrigatório");
	    	checkNotNull(this.escola, "Escola é obrigatorio");
	    	checkNotNull(this.cep, "CEP é obrigatório");
	    	checkNotNull(this.itensSolicitacao, "Itens das solicitação são obrigatórios");
	    	checkArgument(this.itensSolicitacao.size() > 0, "É obrigatório ter itens");
	    	checkNotNull(this.numeroEndereco, "Número de endereço é obrigatório");
	    	checkNotNull(this.responsavel, "Responsável é obrigatório");
	    	
	    	Solicitacao solicitacao = new Solicitacao();
	    	solicitacao.setAluno(PessoaFisica.of(this.aluno));
	    	solicitacao.setCep(this.cep);
	    	solicitacao.setDataChegada(this.dataChegada);
	    	solicitacao.setEndereco(this.endereco);
	    	solicitacao.setEnsino(this.ensino);
	    	solicitacao.setEscola(this.escola);
	    	solicitacao.setItensSolicitacao(this.itensSolicitacao);
	    	solicitacao.setMunicipio(Cidade.of(this.municipio));
	    	
	    	if (id != null) {
	    		solicitacao.setId(id);
	    	}
	    	
	    	solicitacao.setNre(Cidade.of(this.nre));
	    	solicitacao.setNumeroEndereco(this.numeroEndereco);
	    	solicitacao.setResponsavel(PessoaFisica.of(this.responsavel));
	    	solicitacao.setSerie(this.serie);
	    	
	    	for(SolicitacaoItem item : solicitacao.getItensSolicitacao()) {
				item.setSolicitacao(solicitacao);
			}
	    	
	    	return solicitacao;
		}

		public SolicitacaoBuilder adicionarItens(
				List<ComandoSalvarSolicitacaoItem> itensSolicitacao) {
			return null;
		}

		public SolicitacaoBuilder id(Long id) {
			this.id = id;
			return this;
		}
	    
	}
}
