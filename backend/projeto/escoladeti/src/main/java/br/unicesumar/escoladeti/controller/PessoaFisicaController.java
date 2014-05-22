/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.PessoaFisica;
import br.unicesumar.escoladeti.service.PessoaFisicaService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Walber
 */
@Controller
@RequestMapping(value = "/rest/pessoaFisicaSource")
public class PessoaFisicaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @RequestMapping(value = "/pessoaFisica", method = RequestMethod.POST)
    @ResponseBody
    public PessoaFisica salvar(@RequestBody PessoaFisica pf) {
        return this.pessoaFisicaService.salvar(pf);
    }

    @RequestMapping(value = "/pessoaFisica", method = RequestMethod.GET)
    @ResponseBody
    public List<PessoaFisica> getTodos() {
        return this.pessoaFisicaService.getTodos();
    }
    
    @RequestMapping(value = "/pessoaFisica/{idPessoaFisica}",method = RequestMethod.GET)
    @ResponseBody
    public PessoaFisica getById(@PathVariable Long id){
        return this.pessoaFisicaService.findById(id);
    }
    
    @RequestMapping(value = "/pessoaFisica",method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody PessoaFisica pf){
        this.pessoaFisicaService.deletar(pf);
        return "Deleted";
    }
}