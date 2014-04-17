package br.com.repository;

import br.com.entity.Entidade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntidadeRepository extends JpaRepository<Entidade, Long> {
    
    Entidade findById();
    
    List<Entidade> findByNomeContainingOrderByNomeAsc(String nome);
    
}
