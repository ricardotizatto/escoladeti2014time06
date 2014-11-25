
package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
   
    public Estoque findById(Long id);    
    
//    public Page<Estoque> findByNomeContainingOrderByNomeAsc(String nome, Pageable pageable);

//	public List<Estoque> findByProdutoId(Long idProduto); 
    
}

