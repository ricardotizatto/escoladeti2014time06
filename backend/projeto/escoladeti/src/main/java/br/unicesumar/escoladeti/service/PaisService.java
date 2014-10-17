package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Pais;
import br.unicesumar.escoladeti.repository.PaisRepository;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaisService implements Serializable{
	
	@Autowired
	private PaisRepository paisRepository;
	
        @Transactional
	public Pais salvar(Pais pais) {
            Pais paisTemp = new Pais();
            paisTemp = paisRepository.findByNome(pais.getNome());
            if(paisTemp != null){
                if(paisTemp.getId() != pais.getId()){
                    throw new RuntimeException("O país " + pais.getNome() + " já está cadastrado!");
                }
            }
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

    public List<Pais> getTodos() {
        return this.paisRepository.findAll();
    }
}
