package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.Pais;
import br.unicesumar.escoladeti.entity.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    public Page<PessoaFisica> findByNomeContainingOrderByNomeAsc(String nome, Pageable pageable);

    public PessoaFisica findById(Long id);

}
