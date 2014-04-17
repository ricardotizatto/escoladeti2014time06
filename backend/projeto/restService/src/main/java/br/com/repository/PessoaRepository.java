package br.com.repository;

import br.com.entity.Pessoa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    Pessoa findById();
    
    List<Pessoa> findByNomeContainingOrderByNomeAsc(String nome);
    
}
