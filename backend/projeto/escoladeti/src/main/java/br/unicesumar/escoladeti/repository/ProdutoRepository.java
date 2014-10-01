package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Produto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    public Produto findById(Long id);
    
    public Produto findByNome(String nome);
    
    public Page<Produto> findByNomeContainingOrderByNomeAsc(String nome, Pageable pageable);
}
