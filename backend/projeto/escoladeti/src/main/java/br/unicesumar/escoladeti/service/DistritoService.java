
package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Distrito;
import br.unicesumar.escoladeti.entity.Entidade;
import br.unicesumar.escoladeti.repository.DistritoRepository;
import javax.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistritoService extends Entidade {
    
    @Autowired
    private DistritoRepository distritoRepository;
    
    public Distrito salvar(Distrito distrito){
        return this.distritoRepository.save(distrito);
    }
    public DataPage<Distrito> getTodos(Integer pagina){
        return new DataPage<>(distritoRepository.findAll(pageRequestForAsc(pagina, "nome")));
    }
    public DataPage<Distrito> getDistritoPorNome(String nomeParcial){
        return new DataPage<Distrito>(distritoRepository.findByNomeContainingOrderByNomeAsc(nomeParcial, pageRequestForAsc(1, "nome")));
    }
    public void deletar(Distrito distrito){
        this.distritoRepository.delete(distrito);
    }
    
    public Distrito getById(Long id){
        return this.distritoRepository.findById(id);
    }
}
