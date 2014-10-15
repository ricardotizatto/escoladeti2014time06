package br.unicesumar.escoladeti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unicesumar.escoladeti.entity.Caracteristica;
import br.unicesumar.escoladeti.repository.CaracteristicaRepository;


@Service
public class CaracteristicaService {
	
	@Autowired
	private CaracteristicaRepository caracteristicaRepository;
	
	
	public List<Caracteristica> findAll(){
		return this.caracteristicaRepository.findAll();
	}

}
