package br.unicesumar.escoladeti.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    public Page<PessoaFisica> findByNomeContainingOrSobrenomeContainingOrCpfContainingOrderByNomeAsc(String nome, String sobrenomenome, String cpf, Pageable pageable);

    public PessoaFisica findById(Long id);

    public PessoaFisica findByCpf(String cpf);

    public PessoaFisica findByCpfAndIdNot(String cpf, Long id);

}
