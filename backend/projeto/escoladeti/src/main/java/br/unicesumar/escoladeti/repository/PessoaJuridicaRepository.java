package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.PessoaFisica;
import br.unicesumar.escoladeti.entity.PessoaJuridica;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {
    public List<PessoaJuridica> findByNomeContainingOrderByNomeAsc(String nome);
    
    public Page<PessoaJuridica> findByNomeContainingOrderByNomeAsc(String nome, Pageable pageable);
    
}
