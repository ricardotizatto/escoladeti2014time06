package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    public List<PessoaFisica> findByNomeContainingOrderByNomeAsc(String nome);

    public PessoaFisica findById(Long id);

}
