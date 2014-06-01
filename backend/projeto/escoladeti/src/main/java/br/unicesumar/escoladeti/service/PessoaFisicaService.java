/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unicesumar.escoladeti.service;

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
    
    public PessoaFisica findById(Long id){
        return this.pessoaFisicaRepository.findById(id);
    }
    
    public List<PessoaFisica> getTodos(){
        return this.pessoaFisicaRepository.findAll();
    }
    
    public void deletar(PessoaFisica pf){
        this.pessoaFisicaRepository.delete(pf);
    }
    
}
