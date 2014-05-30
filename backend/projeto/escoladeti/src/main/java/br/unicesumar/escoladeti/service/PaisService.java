package br.unicesumar.escoladeti.service;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.Pais;
import br.unicesumar.escoladeti.repository.PaisRepository;

@Service
public class PaisService {
	@Autowired
	private PaisRepository paisRepository;
	
	public Pais salvar(Pais pais) {
		return paisRepository.save(pais);
	}
	
	public DataPage<Pais> getTodos(Integer pagina){
//		return paisRepository.findAll();
		return new DataPage<>(paisRepository.findAll(pageRequestForAsc(pagina, "nome")));
	}
	
	public void deletar(Pais pais) {
		paisRepository.delete(pais);
	}
	
	public Pais getById(Long id) {
		return paisRepository.findById(id);
	}
}
