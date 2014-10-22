package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.view.ViewMaterialProduzido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialStatusRepository extends JpaRepository<ViewMaterialProduzido, Long> {
    
    public List<ViewMaterialProduzido> findByStatusContainingOrderByNomeAsc(String status);
    
}
