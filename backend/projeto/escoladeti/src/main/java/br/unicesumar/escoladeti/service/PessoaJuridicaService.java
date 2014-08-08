/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unicesumar.escoladeti.service;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.PessoaJuridica;
import br.unicesumar.escoladeti.repository.PessoaJuridicaRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Walber
 */

@Service
@Transactional
public class PessoaJuridicaService {
    
    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;
    
    public PessoaJuridica salvar(PessoaJuridica pj){
        return this.pessoaJuridicaRepository.save(pj);
    }
    
    public PessoaJuridica editar(PessoaJuridica pj){
        return this.pessoaJuridicaRepository.saveAndFlush(pj);
    }
    
    public PessoaJuridica findOne(Long id){
        return this.pessoaJuridicaRepository.findOne(id);
    }
    
    public DataPage<PessoaJuridica> getTodos(Integer pagina){
    	return new DataPage<>(pessoaJuridicaRepository.findAll(pageRequestForAsc(pagina, "nome")));
    }
    
    public void deletar(PessoaJuridica pf){
        this.pessoaJuridicaRepository.delete(pf);
    }
    
	public DataPage<PessoaJuridica> getPessoaJuridicaPorNome(String nomeParcial) {
		return new DataPage<PessoaJuridica>(pessoaJuridicaRepository.findByNomeContainingOrderByNomeAsc(nomeParcial, pageRequestForAsc(1, "nome")));
	}
}
