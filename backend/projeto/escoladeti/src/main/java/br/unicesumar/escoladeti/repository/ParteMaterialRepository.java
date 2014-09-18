package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Volume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParteMaterialRepository  extends JpaRepository<Volume, Long> {
    
    Volume findByStatus(String status);
    
    Volume findByResponsavel(String nomeResponsavel);
}
