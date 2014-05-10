package br.unicesumar.escoladeti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unicesumar.escoladeti.entity.UnidadeFederativa;
import br.unicesumar.escoladeti.repository.UnidadeFederativaRepository;

@Service
public class UnidadeFederativaService {
	@Autowired
	private UnidadeFederativaRepository federativaRepository;
	
	public UnidadeFederativa salvar(UnidadeFederativa unidadeFederativa) {
		return this.federativaRepository.save(unidadeFederativa);
	}
	
	public void deletar(UnidadeFederativa federativa) {
		this.federativaRepository.delete(federativa);
	}
	
	public List<UnidadeFederativa> getTodos() {
		return this.federativaRepository.findAll();
	}
	
	public UnidadeFederativa getById(Long id) {
		return this.federativaRepository.findById(id);
	}

}
