package br.unicesumar.escoladeti.comandos;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

public class ComandoSalvarSolicitacao {
	
	private Long nre;
	
	private Long escola;
	
	@Min(value=1,message="aluno é obrigatório")
	private Long aluno;
	
	private String cep;
	
	private String endereco;
	
	private Integer numeroEndereco;
	
	@NotBlank
	private String serie;
	
	private String ensino;
	
	private Long responsavel;
	
	private String dataChegada;

	public Long getNre() {
		return nre;
	}

	public void setNre(Long nre) {
		this.nre = nre;
	}

	public Long getEscola() {
		return escola;
	}

	public void setEscola(Long escola) {
		this.escola = escola;
	}

	public Long getAluno() {
		return aluno;
	}

	public void setAluno(Long aluno) {
		this.aluno = aluno;
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

	public String getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(String dataChegada) {
		this.dataChegada = dataChegada;
	}
	 
	
	
	
}
