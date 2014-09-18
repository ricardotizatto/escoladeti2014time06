package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.Volume;
import br.unicesumar.escoladeti.repository.ParteMaterialRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParteMaterialService {

    @Autowired
    private ParteMaterialRepository parteMaterialRepository;

    public Volume findByStatus(String status) {
       return parteMaterialRepository.findByStatus(status);
    }

    public Volume findByResponsavel(String nomeResponsavel) {
        return parteMaterialRepository.findByResponsavel(nomeResponsavel);
    }
    
    public Volume salvar(Volume parteMaterial) {
        return parteMaterialRepository.save(parteMaterial);
    }
    
    public void remover(Volume parteMaterial) {
        parteMaterialRepository.delete(parteMaterial);
    }
    
    public List<Volume> getTodos() {
        return parteMaterialRepository.findAll();
    }
    
    public Volume getById(Long id) {
        return parteMaterialRepository.findOne(id);
    }
}
