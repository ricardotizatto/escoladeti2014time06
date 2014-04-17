package br.com.repository;

import br.com.entity.Cidade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    
    Cidade findById();
    
    List<Cidade> findByNomeContainingOrderByNomeAsc(String nome);
    
}
