package br.unicesumar.escoladeti.comando;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComandoSalvarSolicitacao {

	@NotNull(message = "Aluno é obrigatório")
	@Min(value = 0, message = "Aluno é obrigatório")
	private Long aluno;

	private Long escola;

	@Min(value = 0, message = "Nre inválido")
	private Long nre;

	@NotNull(message = "Municipio é obrigatório")
	@Min(value = 0, message = "municipio é obrigatório")
	private Long enderecoMunicipio;

	@NotBlank(message = "CEP é obrigatório")
	@Length(min = 0, max = 9, message = "Tamanho inválido para o cep")
	private String enderecoCep;

	@NotBlank(message = "Tipo de endereço é obrigatório")
	private String enderecoTipo;

	@NotBlank(message = "Endereço é obrigatório")
	private String enderecoLogradouro;

	@NotNull(message = "Número do endereço é obrigatório")
	@Min(value = 0, message = "Número do endereço é obrigatório")
	private Integer enderecoNumero;

	@NotBlank(message = "Bairro é obrigatório")
	private String enderecoBairro;

	private String enderecoComplemento;

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

	public Long getEscola() {
		return escola;
	}

	public void setEscola(Long escola) {
		this.escola = escola;
	}

	public Long getNre() {
		return nre;
	}

	public void setNre(Long nre) {
		this.nre = nre;
	}

	public Long getEnderecoMunicipio() {
		return enderecoMunicipio;
	}

	public void setEnderecoMunicipio(Long municipio) {
		this.enderecoMunicipio = municipio;
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

	public void setItensSolicitacao(
			List<ComandoSalvarSolicitacaoItem> itensSolicitacao) {
		this.itensSolicitacao = itensSolicitacao;
	}

	public Date getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}

	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}

	public String getEnderecoCep() {
		return enderecoCep;
	}

	public void setEnderecoCep(String enderecoCep) {
		this.enderecoCep = enderecoCep;
	}

	public String getEnderecoTipo() {
		return enderecoTipo;
	}

	public void setEnderecoTipo(String enderecoTipo) {
		this.enderecoTipo = enderecoTipo;
	}

	public String getEnderecoLogradouro() {
		return enderecoLogradouro;
	}

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = enderecoLogradouro;
	}

	public Integer getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(Integer enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getEnderecoBairro() {
		return enderecoBairro;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}

}
