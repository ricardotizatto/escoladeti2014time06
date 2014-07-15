package br.unicesumar.escoladeti.controller;

import java.io.Serializable;
import java.util.List;

import org.neo4j.cypher.internal.compiler.v2_1.planner.logical.steps.sortSkipAndLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unicesumar.escoladeti.entity.Solicitacao;
import br.unicesumar.escoladeti.repository.SolicitacaoRepository;

@Controller
@RequestMapping("/rest/solicitacaoResouce")
public class SolicitacaoController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SolicitacaoRepository repository;	
	
    
	@RequestMapping(value = "/solicitacao", method = RequestMethod.POST)	
	@ResponseBody
	public Solicitacao salvar(@RequestBody Solicitacao solicitacao) {
		return repository.save(solicitacao);
	}
    
    
	@RequestMapping(value = "/solicitacao", method = RequestMethod.GET)	
	@ResponseBody
	public List<Solicitacao> retornarTodos() {
		return repository.findAll();
	}

}
