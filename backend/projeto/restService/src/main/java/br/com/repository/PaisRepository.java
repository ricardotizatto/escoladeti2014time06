package br.com.repository;

import br.com.entity.Pais;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    
    Pais findById();
    
    List<Pais> findByNomeContainingOrderByNomeAsc(String nome);
    
}
