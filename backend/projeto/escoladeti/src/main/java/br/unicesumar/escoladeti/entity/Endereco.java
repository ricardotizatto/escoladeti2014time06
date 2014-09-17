package br.unicesumar.escoladeti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.unicesumar.escoladeti.enums.TipoEndereco;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Endereco extends Entidade {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(length = 10)
    @NotNull
    @NotEmpty
    private String cep;

    @Column(length = 10)
    @NotNull
    private int numero;

    @NotNull
    private String logradouro;

    @Column(length = 100)
    private String complemento;

    @NotNull
    private char principal;

    @Enumerated(EnumType.STRING)
    private TipoEndereco tipo;
    
    @NotNull
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "pessoaid", referencedColumnName = "id")
    @JsonBackReference
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "cidadeid", nullable = false)
    private Cidade cidade;
    
    public Endereco(){
    }
    
    public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public char getPrincipal() {
        return principal;
    }

    public void setPrincipal(char principal) {
        this.principal = principal;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
}
