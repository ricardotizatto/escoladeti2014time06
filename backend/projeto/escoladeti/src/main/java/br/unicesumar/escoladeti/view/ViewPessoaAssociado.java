package br.unicesumar.escoladeti.view;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.unicesumar.escoladeti.mask.Mascara;

@Entity(name = "viewpessoaassociado")
public class ViewPessoaAssociado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String nome;
	private String email;
	private Character tipo;
	private String cpf_cnpj;
	private String rg_inscricaomunicipal;

	@Temporal(TemporalType.DATE)
	private Date nascimento_criacao;

	private String descricao;

	private String pago;

	@Temporal(TemporalType.DATE)
	private Date vigencia;

	public ViewPessoaAssociado() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public String getCpf_cnpj() {
		if (this.tipo.equals('F')) {
			return Mascara.cpf(this.cpf_cnpj);
		} else {
			return Mascara.cpnj(this.cpf_cnpj);
		}
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getRg_inscricaomunicipal() {
		return rg_inscricaomunicipal;
	}

	public void setRg_inscricaomunicipal(String rg_inscricaomunicipal) {
		this.rg_inscricaomunicipal = rg_inscricaomunicipal;
	}

	public Date getNascimento_criacao() {
		return nascimento_criacao;
	}

	public void setNascimento_criacao(Date nascimento_criacao) {
		this.nascimento_criacao = nascimento_criacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPago() {
		return pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}
	public String getVigencia() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		return sdf.format(this.vigencia);
	}	

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
