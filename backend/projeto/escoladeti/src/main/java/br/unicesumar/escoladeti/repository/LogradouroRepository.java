package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.Logradouro;

public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {
    
    public Logradouro findById();
    
    public List<Logradouro> findByNomeContainingOrderByNomeAsc(String nome);
    
}
