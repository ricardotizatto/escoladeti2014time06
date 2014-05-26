package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.ParteMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParteMaterialRepository  extends JpaRepository<ParteMaterial, Long> {
    
    
    ParteMaterial findByStatus(String status);
    
    ParteMaterial findByResponsavel(String nomeResponsavel);
    
    ParteMaterial findByRevisao(String nomeRevisao);
}
