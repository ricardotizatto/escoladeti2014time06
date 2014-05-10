package br.unicesumar.escoladeti.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Entidade {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	protected Long id;
	
	public Entidade() {
	
	}

	public Long getId() {
		return id;
	}
}
