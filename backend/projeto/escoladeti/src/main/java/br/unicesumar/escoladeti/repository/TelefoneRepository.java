package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    public List<Telefone> findByNomeContainingOrderByNomeAsc(String nome);
    
}
