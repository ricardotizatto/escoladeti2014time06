package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.UnidadeFederativa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.Solicitacao;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long>{
    public Page<Solicitacao> findByIdOrderByIdAsc(Long id, Pageable pageable);
}
