package br.com.repository;

import br.com.entity.Logradouro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {
    
    Logradouro findById();
    
    List<Logradouro> findByNomeContainingOrderByNomeAsc(String nome);
    
}
