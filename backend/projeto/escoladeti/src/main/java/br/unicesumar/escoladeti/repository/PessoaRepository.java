package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    public Pessoa findById();
    
    public List<Pessoa> findByNomeContainingOrderByNomeAsc(String nome);
    
}
