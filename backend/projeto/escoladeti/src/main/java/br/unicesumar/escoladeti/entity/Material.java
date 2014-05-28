package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class Material extends Entidade{	
	
	private static final long serialVersionUID = 1L;

	public abstract String getInfo();

}
