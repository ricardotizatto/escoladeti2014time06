package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

    public Pais findById(Long id);

    
    public Page<Pais> findByNomeContainingOrderByNomeAsc(String nome, Pageable pageable);    
   

}
