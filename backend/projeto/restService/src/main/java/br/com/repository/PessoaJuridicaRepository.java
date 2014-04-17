package br.com.repository;

import br.com.entity.PessoaJuridica;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {
    
    PessoaJuridica findById();
    
    List<PessoaJuridica> findByNomeContainingOrderByNomeAsc(String nome);
    
}
