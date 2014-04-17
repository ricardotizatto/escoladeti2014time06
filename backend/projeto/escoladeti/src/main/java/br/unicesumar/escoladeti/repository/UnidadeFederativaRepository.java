package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.UnidadeFederativa;

public interface UnidadeFederativaRepository extends JpaRepository<UnidadeFederativa, Long> {
    
    public UnidadeFederativa findById();
    
    public List<UnidadeFederativa> findByNomeContainingOrderByNomeAsc(String nome);
    
}
