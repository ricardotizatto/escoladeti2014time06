package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    
    public Pais findById();
    
    public List<Pais> findByNomeContainingOrderByNomeAsc(String nome);
    
}
