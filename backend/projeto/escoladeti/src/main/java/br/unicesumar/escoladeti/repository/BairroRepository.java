package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.Bairro;


public interface BairroRepository extends JpaRepository<Bairro, Long> {
    public Bairro findById();
    public List<Bairro> findByNomeContainingOrderByNomeAsc(String nome);    
}
