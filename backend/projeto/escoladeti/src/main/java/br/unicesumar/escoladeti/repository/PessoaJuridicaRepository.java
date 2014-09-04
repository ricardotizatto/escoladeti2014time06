package br.unicesumar.escoladeti.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.PessoaJuridica;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {
    
    public Page<PessoaJuridica> findByNomeContainingOrCnpjContainingOrderByNomeAsc(String nome, String cnpj, Pageable pageable);

    public PessoaJuridica findByCnpj(String cnpj);
    
}
