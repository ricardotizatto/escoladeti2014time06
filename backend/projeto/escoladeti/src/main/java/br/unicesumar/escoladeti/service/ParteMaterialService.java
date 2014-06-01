package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.ParteMaterial;
import br.unicesumar.escoladeti.repository.ParteMaterialRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParteMaterialService {

    @Autowired
    private ParteMaterialRepository parteMaterialRepository;

    public ParteMaterial findByStatus(String status) {
       return parteMaterialRepository.findByStatus(status);
    }

    public ParteMaterial findByResponsavel(String nomeResponsavel) {
        return parteMaterialRepository.findByResponsavel(nomeResponsavel);
    }
    
    public ParteMaterial salvar(ParteMaterial parteMaterial) {
        return parteMaterialRepository.save(parteMaterial);
    }
    
    public void remover(ParteMaterial parteMaterial) {
        parteMaterialRepository.delete(parteMaterial);
    }
    
    public List<ParteMaterial> getTodos() {
        return parteMaterialRepository.findAll();
    }
    
    public ParteMaterial getById(Long id) {
        return parteMaterialRepository.findOne(id);
    }
}
