package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Pais;
import br.unicesumar.escoladeti.repository.PaisRepository;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService implements Serializable{
	
	@Autowired
	private PaisRepository paisRepository;
	
	public Pais salvar(Pais pais) {
		return paisRepository.save(pais);
	}
        
	public List<Pais> listarTodosPaises() {
		return paisRepository.findAll();
	}
	
	public DataPage<Pais> getTodos(Integer pagina){
		return new DataPage<>(paisRepository.findAll(pageRequestForAsc(pagina, "nome")));
	}
        
	public DataPage<Pais> getPaisPorNome(String nomeParcial) {
		return new DataPage<>(paisRepository.findByNomeContainingOrderByNomeAsc(nomeParcial, pageRequestForAsc(1, "nome")));
		
	}
	
	public void deletar(Pais pais) {
		paisRepository.delete(pais);
	}
	
	public Pais getById(Long id) {
		return paisRepository.findById(id);
	}
        public Pais buscarPaisPorNomeSiglaCodigo(Pais pais) {
       return this.paisRepository.findByNomeAndSiglaAndCodigo(
                pais.getNome(), pais.getSigla(), pais.getCodigo());
    }
}
