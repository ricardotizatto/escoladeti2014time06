package br.com.repository;

import br.com.entity.PessoaFisica;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
    
    PessoaFisica findById();
    
    List<PessoaFisica> findByNomeContainingOrderByNomeAsc(String nome);
    
}
