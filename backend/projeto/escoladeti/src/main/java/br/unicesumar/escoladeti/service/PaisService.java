package br.unicesumar.escoladeti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unicesumar.escoladeti.entity.Pais;
import br.unicesumar.escoladeti.repository.PaisRepository;

@Service
public class PaisService {
	@Autowired
	private PaisRepository paisRepository;
	
	public Pais salvar(Pais pais) {
		return paisRepository.save(pais);
	}
	
	public List<Pais> getTodos(){
		return paisRepository.findAll();
	}
	
	public void deletar(Pais pais) {
		paisRepository.delete(pais);
	}
	
	public Pais getById(Long id) {
		return paisRepository.findById(id);
	}
}
