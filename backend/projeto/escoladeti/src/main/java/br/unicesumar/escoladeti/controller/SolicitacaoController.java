package br.unicesumar.escoladeti.controller;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;

import java.io.Serializable;
import java.util.List;

import org.neo4j.cypher.internal.compiler.v2_1.planner.logical.steps.sortSkipAndLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unicesumar.escoladeti.entity.Pais;
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
	
	@RequestMapping(value= {"/solicitacao/{id}"}, method = RequestMethod.GET )
	@ResponseBody
	public Solicitacao getSolicitacao(@PathVariable Long id) {
		return repository.findOne(id);
	}
	
	@RequestMapping(value = { "/solicitacao/pag/{pagina}" }, method = RequestMethod.GET)
	@ResponseBody
	public DataPage<Solicitacao> paginar(@PathVariable Integer pagina) {
		return new DataPage<>(repository.findAll(pageRequestForAsc(pagina, "id")));
	}
	
	
}
