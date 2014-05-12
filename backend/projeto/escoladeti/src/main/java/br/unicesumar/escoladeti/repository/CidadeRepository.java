package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    public Cidade findById(Long id);
    public List<Cidade> findByNomeContainingOrderByNomeAsc(String nome);
}
