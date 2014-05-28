package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.OrdemProducao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemProducaoRepository extends JpaRepository<OrdemProducao, Long> {
    public OrdemProducao findById(Long id);        
}
