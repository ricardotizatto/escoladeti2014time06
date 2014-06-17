package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.UnidadeFederativa;
import br.unicesumar.escoladeti.repository.UnidadeFederativaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadeFederativaService {
	@Autowired
	private UnidadeFederativaRepository federativaRepository;
	
	public UnidadeFederativa salvar(UnidadeFederativa unidadeFederativa) {
		return this.federativaRepository.save(unidadeFederativa);
	}
        
        public DataPage<UnidadeFederativa> getTodos(Integer pagina) {
            return new DataPage<>(federativaRepository.findAll(pageRequestForAsc(pagina, "nome")));
        }

        public DataPage<UnidadeFederativa> getUnidadesFederativasPorNome(String nomeParcial) {
            return new DataPage<UnidadeFederativa>(federativaRepository.findByNomeContainingOrderByNomeAsc(nomeParcial, pageRequestForAsc(1, "nome")));
        }
	
	public void deletar(UnidadeFederativa federativa) {
		this.federativaRepository.delete(federativa);
	}
	
	public UnidadeFederativa getById(Long id) {
		return this.federativaRepository.findById(id);
	}

    public UnidadeFederativa buscarUnidadeFederativaPorNomeSiglaPais(UnidadeFederativa unidadeFederativa) {
        return this.federativaRepository.findByNomeAndSigla(
                unidadeFederativa.getNome(), unidadeFederativa.getSigla());//, unidadeFederativa.getIdPaisDoEstado());
    }

}
