package br.unicesumar.escoladeti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unicesumar.escoladeti.repository.CidadeRepository;
import br.unicesumar.escoladeti.entity.Cidade;

/**
 *
 * @author Frank
 */
@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    public Cidade salvar(Cidade cidade){
        
        return this.cidadeRepository.save(cidade);
    }
    
    public void delete(Cidade cidade){
        
        this.cidadeRepository.delete(cidade);
    }
    
    public List<Cidade> getTodos(){
        
        return this.cidadeRepository.findAll();
    }
    
    public Cidade getById(Long id){
        
        return this.cidadeRepository.findById(id);
    }
}
