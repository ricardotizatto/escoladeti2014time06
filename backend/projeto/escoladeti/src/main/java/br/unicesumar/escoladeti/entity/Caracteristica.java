package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.enums.Tipo;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Caracteristica extends Entidade implements Serializable{
	private static final long serialVersionUID = 1L;

	private String descricao;
	
	@OneToMany(mappedBy = "caracteristica",fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<PessoaCaracteristica> pessoaCaracteristicas;
        
        @Enumerated(EnumType.STRING)
        private Tipo tipo;
	
	public String getDescricao() {
		return descricao;
	}
        
        public void setTipo(Tipo tipo){
          this.tipo = tipo;
        }
        
        public Tipo getTipo(){
          return this.tipo;
        }

	public Set<PessoaCaracteristica> getPessoaCaracteristicas() {
		return pessoaCaracteristicas;
	}

	public void setPessoaCaracteristicas(
			Set<PessoaCaracteristica> pessoaCaracteristicas) {
		this.pessoaCaracteristicas = pessoaCaracteristicas;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Caracteristica(){
	}

}
