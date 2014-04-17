package br.com.repository;

import br.com.entity.Bairro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BairroRepository extends JpaRepository<Bairro, Long> {
    
    Bairro findById();
    
    List<Bairro> findByNomeContainingOrderByNomeAsc(String nome);
    
}
