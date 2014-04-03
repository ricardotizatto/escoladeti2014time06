package br.com.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Entidade {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	public Long getId() {
		return id;
	}
}
