package br.unicesumar.escoladeti.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    public Page<PessoaFisica> findByNomeContainingOrderByNomeAsc(String nome, Pageable pageable);
    
    public Page<PessoaFisica> findByAlunoTrue(Pageable pageable);

    public PessoaFisica findById(Long id);

}
