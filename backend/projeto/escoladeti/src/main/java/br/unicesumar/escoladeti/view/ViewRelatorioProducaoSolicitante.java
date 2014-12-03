package br.unicesumar.escoladeti.view;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.unicesumar.escoladeti.mask.Mascara;

@Entity(name = "viewrelatorioproducaosolicitante")
public class ViewRelatorioProducaoSolicitante implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String aluno;
	private Integer idade;
	private Date nascimentoCriacao;
	private String serie;
	private String ensino;
	private String responsavel;
	private String escola;
	private String endereco;
	private String telefone;
	private String email;
	private String municipioUf;
	private String bairro;
	private String complemento;
	private String cep;
	private String nre;
	private Date datachegada;

	private Date dataimpressao;
	private Date datarevisao;
	private Date dataenvio;

	public ViewRelatorioProducaoSolicitante() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataimpressao() {
		if (this.dataimpressao == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(dataimpressao);
	}

	public void setDataimpressao(Date dataimpressao) {
		this.dataimpressao = dataimpressao;
	}

	public String getDatarevisao() {
		if (this.datarevisao == null)
			return "";		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(datarevisao);
	}

	public void setDatarevisao(Date datarevisao) {
		this.datarevisao = datarevisao;
	}

	public String getDataenvio() {
		if (this.dataenvio == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(dataenvio);
	}

	public void setDataenvio(Date dataenvio) {
		this.dataenvio = dataenvio;
	}

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getNascimentoCriacao() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(nascimentoCriacao);
	}

	public void setNascimentoCriacao(Date nascimentoCriacao) {
		this.nascimentoCriacao = nascimentoCriacao;
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

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return Mascara.telefoneDdd(telefone);
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMunicipioUf() {
		return municipioUf;
	}

	public void setMunicipioUf(String municipioUf) {
		this.municipioUf = municipioUf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return Mascara.cep(cep);
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNre() {
		return nre;
	}

	public void setNre(String nre) {
		this.nre = nre;
	}

	public String getDatachegada() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(datachegada);
	}

	public void setDatachegada(Date datachegada) {
		this.datachegada = datachegada;
	}

}
