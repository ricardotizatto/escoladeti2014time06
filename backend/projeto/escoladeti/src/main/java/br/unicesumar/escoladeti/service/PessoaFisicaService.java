/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unicesumar.escoladeti.service;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.Cidade;
import br.unicesumar.escoladeti.entity.Pais;
import br.unicesumar.escoladeti.entity.PessoaFisica;
import br.unicesumar.escoladeti.repository.PessoaFisicaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Walber
 */

@Service
@Transactional
public class PessoaFisicaService {
    
    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;
    
    public PessoaFisica salvar(PessoaFisica pf){
        return this.pessoaFisicaRepository.save(pf);
    }
    
    public PessoaFisica editar(PessoaFisica pf){
        return this.pessoaFisicaRepository.saveAndFlush(pf);
    }
    
    public PessoaFisica findOne(Long id){
        return this.pessoaFisicaRepository.findOne(id);
    }
    
    public DataPage<PessoaFisica> getTodos(Integer pagina){
    	return new DataPage<>(pessoaFisicaRepository.findAll(pageRequestForAsc(pagina, "nome")));
    }
    
    public void deletar(PessoaFisica pf){
        this.pessoaFisicaRepository.delete(pf);
    }

	public DataPage<PessoaFisica> getPessoaFisicaPorNome(String nomeParcial) {
		return new DataPage<PessoaFisica>(pessoaFisicaRepository.findByNomeContainingOrderByNomeAsc(nomeParcial, pageRequestForAsc(1, "nome")));
	}
    
}
