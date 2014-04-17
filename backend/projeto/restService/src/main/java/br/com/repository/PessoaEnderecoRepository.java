package br.com.repository;

import br.com.entity.PessoaEndereco;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Long> {
    
    PessoaEndereco findById();
    
    List<PessoaEndereco> findByNomeContainingOrderByNomeAsc(String nome);
    
}
