package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.view.ViewVolumeLivro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolumeLivroRepository extends JpaRepository<ViewVolumeLivro, Long> {
    
    public Page<ViewVolumeLivro> findByStatusContainingOrderByNomeAsc(String status, Pageable pageable);
    
    public Page<ViewVolumeLivro> 
        findByNomeContainingOrAutorContainingOrEditoraContainingOrDisciplinaContainingOrTranscricaoContainingOrderByNomeAsc
        (String nome, String autor, String editora, String disciplina, String transcricao, Pageable pageable);

}
