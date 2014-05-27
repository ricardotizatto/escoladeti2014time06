package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.OrdemProducao;
import br.unicesumar.escoladeti.repository.OrdemProducaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemProducaoService {
    @Autowired
    private OrdemProducaoRepository ordemProducaoRepository;
    
    public OrdemProducao salvar(OrdemProducao ordemprocudao){
        return ordemProducaoRepository.save(ordemprocudao);
    }
    
    public List<OrdemProducao> getTodos(){
        return ordemProducaoRepository.findAll();
    }
    
    public void deletar(OrdemProducao ordemProducao){
        ordemProducaoRepository.delete(ordemProducao);
    }
    
    public OrdemProducao getById(Long id){
        return ordemProducaoRepository.findById(id);
    }
    
}
