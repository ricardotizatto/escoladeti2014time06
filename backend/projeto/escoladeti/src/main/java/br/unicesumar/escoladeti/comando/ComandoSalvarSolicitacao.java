package br.unicesumar.escoladeti.comando;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComandoSalvarSolicitacao {
	   
    @NotNull(message = "Aluno é obrigatório" )
    @Min(value = 0, message = "aluno é obrigatório")
    @Max(value = 100)
    private Long aluno;
    
    @NotBlank(message = "Escola é obrigatório")
    private String escola;
    
    @Min(value = 0, message = "Nre inválido")
    private Long nre;

    @NotNull(message = "Municipio é obrigatório")
    @Min(value = 0, message = "municipio é obrigatório")
    private Long municipio;
    
    @NotBlank(message = "CEP é obrigatório")
    @Length(min=0,  max=9, message = "Tamanho inválido para o cep")
    private String cep;    
    
    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;
    
    @NotNull(message = "Número do endereço é obrigatório")
    @Min(value = 0, message = "Número do endereço é obrigatório")
    private Integer numeroEndereco;
    
    private String serie;
    
    private String ensino;

    @NotNull(message = "Responsável é obrigatório")
    @Min(value = 0, message = "Responsável é obrigatório")
    private Long responsavel;

    @NotEmpty(message = "É obrigatório ter ao menos um item na solicitação")
    private List<ComandoSalvarSolicitacaoItem> itensSolicitacao;

    @NotNull(message = "Data de Chegada é obrigatório")
    private Date dataChegada;

	public Long getAluno() {
		return aluno;
	}

	public void setAluno(Long aluno) {
		this.aluno = aluno;
	}

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}

	public Long getNre() {
		return nre;
	}

	public void setNre(Long nre) {
		this.nre = nre;
	}

	public Long getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Long municipio) {
		this.municipio = municipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getEnsino() {
		return ensino;
	}

	public void setEnsino(String ensino) {
		this.ensino = ensino;
	}

	public Long getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Long responsavel) {
		this.responsavel = responsavel;
	}

	public List<ComandoSalvarSolicitacaoItem> getItensSolicitacao() {
		return itensSolicitacao;
	}

	public void setItensSolicitacao(List<ComandoSalvarSolicitacaoItem> itensSolicitacao) {
		this.itensSolicitacao = itensSolicitacao;
	}

	public Date getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}    
    
}
