package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jhonatan on 15/09/2014.
 */
public interface SolicitacaoItemRepository extends JpaRepository<SolicitacaoItem, Long> {
}
