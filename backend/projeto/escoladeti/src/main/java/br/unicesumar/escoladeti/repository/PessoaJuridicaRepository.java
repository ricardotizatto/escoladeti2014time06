package br.unicesumar.escoladeti.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unicesumar.escoladeti.entity.PessoaJuridica;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {
    
    public Page<PessoaJuridica> findByNomeContainingOrCnpjContainingOrderByNomeAsc(String nome, String cnpj, Pageable pageable);

    public PessoaJuridica findByCnpj(String cnpj);

    @Query(nativeQuery = true, value = "select a.id, d.nome " + 
    		"from pessoajuridica a join pessoacaracteristica b on a.id = b.pessoa_id "+
    		"join caracteristica c on b.caracteristica_id = c.id " +
    		"join pessoa d on a.id = d.id " +
    		"where c.descricao = 'ESCOLA'")
	public List<Object[]> findAllEscolas();
    
}