package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.Entidade;

public interface EntidadeRepository extends JpaRepository<Entidade, Long> {
    List<Entidade> findByNomeContainingOrderByNomeAsc(String nome);
    
}
