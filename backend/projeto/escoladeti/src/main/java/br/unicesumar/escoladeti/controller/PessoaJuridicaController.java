/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unicesumar.escoladeti.entity.PessoaJuridica;
import br.unicesumar.escoladeti.service.PessoaJuridicaService;

/**
 *
 * @author Walber
 */
@Controller
@RequestMapping(value = "/rest/pessoaJuridicaSource")
public class PessoaJuridicaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @RequestMapping(value = "/pessoaJuridica", method = RequestMethod.POST)
    @ResponseBody
    public PessoaJuridica salvar(@RequestBody PessoaJuridica pj) {
        return this.pessoaJuridicaService.salvar(pj);
    }
    
    @RequestMapping(value = "/pessoaJuridica", method = RequestMethod.PUT)
    @ResponseBody
    public PessoaJuridica editar(@RequestBody PessoaJuridica pj) {
        return this.pessoaJuridicaService.salvar(pj);
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<PessoaJuridica> getTodos() {
        return this.pessoaJuridicaService.getTodos(1);
    }
	@RequestMapping(value = { "/listar/pag/{pagina}" }, method = RequestMethod.GET)
	@ResponseBody
	public DataPage<PessoaJuridica> listarPais(@PathVariable Integer pagina) {
		return pessoaJuridicaService.getTodos(pagina);
	}
	
	@RequestMapping(value = "/pessoaJuridica",params = {"q"}, method = RequestMethod.GET)
	@ResponseBody
	public DataPage<PessoaJuridica> getPorNome(@RequestParam String q) {
		return pessoaJuridicaService.getPessoaJuridicaPorNome(q);
	}
    
    @RequestMapping(value = "/pessoaJuridica/{idPessoaJuridica}",method = RequestMethod.GET)
    @ResponseBody
    public PessoaJuridica getById(@PathVariable Long idPessoaJuridica){
    	new RuntimeException("Erro: "+ idPessoaJuridica );
        return this.pessoaJuridicaService.findOne(idPessoaJuridica);
    }
    
  
    @RequestMapping(value = "/pessoaJuridica",method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody PessoaJuridica pf){
        this.pessoaJuridicaService.deletar(pf);
        return "Deleted";
    }
}