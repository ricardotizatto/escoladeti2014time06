package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    public List<Endereco> findByNomeContainingOrderByNomeAsc(String nome);
    
}
