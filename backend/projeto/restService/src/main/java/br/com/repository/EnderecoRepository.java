package br.com.repository;

import br.com.entity.Endereco;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
    Endereco findById();
    
    List<Endereco> findByNomeContainingOrderByNomeAsc(String nome);
    
}
