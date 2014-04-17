package br.com.repository;

import br.com.entity.Telefone;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    
    Telefone findById();
    
    List<Telefone> findByNomeContainingOrderByNomeAsc(String nome);
    
}
