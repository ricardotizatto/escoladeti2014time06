package br.com.repository;

import br.com.entity.FaixaDeCep;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaixaDeCepRepository extends JpaRepository<FaixaDeCep, Long> {
    
    FaixaDeCep findById();
    
    List<FaixaDeCep> findByNomeContainingOrderByNomeAsc(String nome);
    
}
