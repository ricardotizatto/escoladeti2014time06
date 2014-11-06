package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import br.unicesumar.escoladeti.enums.Transcricao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitacaoItemRepository extends JpaRepository<SolicitacaoItem, Long>{
    List<SolicitacaoItem> findByLivroIdAndTraducaoMaterial(Long idLivro, Transcricao transcricao);
}


