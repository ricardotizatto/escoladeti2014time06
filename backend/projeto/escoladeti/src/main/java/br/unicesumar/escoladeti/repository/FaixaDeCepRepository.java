package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.FaixaCep;

public interface FaixaDeCepRepository extends JpaRepository<FaixaCep, Long> {
    public FaixaCep findById();
    public List<FaixaCep> findByNomeContainingOrderByNomeAsc(String nome);
    
}
