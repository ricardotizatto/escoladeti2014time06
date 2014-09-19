package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Movimentacao;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    
    public Movimentacao findById(Long id);
    
}
