/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unicesumar.escoladeti.entity.PessoaFisica;
import br.unicesumar.escoladeti.service.PessoaFisicaService;

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
    
    @RequestMapping(value = "/pessoaFisica", method = RequestMethod.PUT)
    @ResponseBody
    public PessoaFisica editar(@RequestBody PessoaFisica pf) {
        return this.pessoaFisicaService.salvar(pf);
    }
	@RequestMapping(value = "/pessoaFisica",params = {"q"}, method = RequestMethod.GET)
	@ResponseBody
	public DataPage<PessoaFisica> getPorNome(@RequestParam String q) {
		return pessoaFisicaService.getPessoaFisicaPorNome(q);
	}

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<PessoaFisica> getTodos() {
        return this.pessoaFisicaService.getTodos(1);
    }
	@RequestMapping(value = { "/listar/pag/{pagina}" }, method = RequestMethod.GET)
	@ResponseBody
	public DataPage<PessoaFisica> listarPais(@PathVariable Integer pagina) {
		return pessoaFisicaService.getTodos(pagina);
	}
    
    @RequestMapping(value = "/pessoaFisica/{idPessoaFisica}",method = RequestMethod.GET)
    @ResponseBody
    public PessoaFisica getById(@PathVariable Long idPessoaFisica){
    	new RuntimeException("Erro: "+ idPessoaFisica );
        return this.pessoaFisicaService.findOne(idPessoaFisica);
    }
    
  
    @RequestMapping(value = "/pessoaFisica",method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody PessoaFisica pf){
        this.pessoaFisicaService.deletar(pf);
        return "Deleted";
    }
    
    @RequestMapping(value = "/pessoaFisica/lista",method = RequestMethod.GET)
    @ResponseBody
    public List<PessoaFisica> listar(){
        return pessoaFisicaService.listarTodos();
    }
}