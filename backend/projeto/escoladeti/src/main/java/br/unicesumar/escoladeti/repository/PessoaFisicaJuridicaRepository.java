/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.view.PessoaFisicaJuridica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Walber
 */
public interface PessoaFisicaJuridicaRepository extends JpaRepository<PessoaFisicaJuridica, Long>{
    
        public Page<PessoaFisicaJuridica> findByNomeContainingOrCpfCnpjContainingOrderByNomeAsc(String nome, String cpfCnpj, Pageable pageable);
       
}
