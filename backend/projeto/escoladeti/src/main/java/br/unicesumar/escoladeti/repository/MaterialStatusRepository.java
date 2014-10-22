package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.view.ViewMaterialProduzido;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialStatusRepository extends JpaRepository<ViewMaterialProduzido, Long> {
    
    public Page<ViewMaterialProduzido> findByStatusContainingOrderByNomeAsc(String status, Pageable pageable);
    
    public Page<ViewMaterialProduzido> 
        findByNomeContainingOrAutorContainingOrEditoraContainingOrDisciplinaContainingOrTranscricaoContainingOrderByNomeAsc
        (String nome, String autor, String editora, String disciplina, String transcricao, Pageable pageable);

}
