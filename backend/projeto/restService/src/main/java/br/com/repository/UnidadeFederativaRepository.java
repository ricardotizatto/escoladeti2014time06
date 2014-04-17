package br.com.repository;

import br.com.entity.UnidadeFederativa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeFederativaRepository extends JpaRepository<UnidadeFederativa, Long> {
    
    UnidadeFederativa findById();
    
    List<UnidadeFederativa> findByNomeContainingOrderByNomeAsc(String nome);
    
}
