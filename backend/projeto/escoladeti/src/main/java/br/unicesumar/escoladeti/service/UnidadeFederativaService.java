package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Pais;
import br.unicesumar.escoladeti.entity.UnidadeFederativa;
import br.unicesumar.escoladeti.repository.UnidadeFederativaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UnidadeFederativaService {
    @Autowired
    private UnidadeFederativaRepository federativaRepository;
    
    @Transactional
    public UnidadeFederativa salvar(UnidadeFederativa unidadeFederativa) {
        UnidadeFederativa ufTemp = new UnidadeFederativa();
        ufTemp = this.federativaRepository.findByNome(unidadeFederativa.getNome());
        
        if(ufTemp != null){
            if(ufTemp.getId() != unidadeFederativa.getId()){
                throw new RuntimeException("O estado " + unidadeFederativa.getNome() + " já está cadastrado!");
            }
        }
        
            return this.federativaRepository.save(unidadeFederativa);
    }
    
    public List<UnidadeFederativa> listaTodos() {
        return this.federativaRepository.findAll();
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

    public UnidadeFederativa buscarUnidadeFederativaPorNomeSigla(UnidadeFederativa unidadeFederativa) {
        return this.federativaRepository.findByNomeAndSigla(
                unidadeFederativa.getNome(), unidadeFederativa.getSigla());//, unidadeFederativa.getIdPaisDoEstado());
    }

	public List<UnidadeFederativa> buscarUnidadeFederativaPorIdDoPais(Long idPais) {
		return this.federativaRepository.findByPaisId(idPais);
	}

}
