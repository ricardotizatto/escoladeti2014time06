package br.com.repository;

import br.com.entity.Distrito;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistritoRepository extends JpaRepository<Distrito, Long> {
    
    Distrito findById();
    
    List<Distrito> findByNomeContainingOrderByNomeAsc(String nome);
    
}
