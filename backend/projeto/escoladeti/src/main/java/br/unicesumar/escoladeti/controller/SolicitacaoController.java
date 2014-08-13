package br.unicesumar.escoladeti.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unicesumar.escoladeti.comando.ComandoSalvarSolicitacao;
import br.unicesumar.escoladeti.entity.Solicitacao;
import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import br.unicesumar.escoladeti.service.SolicitacaoService;

@Controller
@RequestMapping("/rest/solicitacoes")
public class SolicitacaoController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SolicitacaoService solicitacaoService;	
	
    
	@RequestMapping( method = RequestMethod.POST)	
	@ResponseBody
	public Solicitacao salvar(@Valid @RequestBody ComandoSalvarSolicitacao comando) {		
		return solicitacaoService.salvar(comando);
	}
    
	@RequestMapping(method = RequestMethod.GET)	
	@ResponseBody
	public List<Solicitacao> retornarTodos() {
		return solicitacaoService.listar();
	}
	
	@RequestMapping( value= {"/{id}"}, method = RequestMethod.GET )
	@ResponseBody
	public Solicitacao getSolicitacao(@PathVariable Long id) {
		return solicitacaoService.buscar(id);
	}
	
	@RequestMapping(value = { "/paginar/{pagina}" }, method = RequestMethod.GET)
	@ResponseBody
	public DataPage<Solicitacao> paginar(@PathVariable Integer pagina) {
		return solicitacaoService.paginar(pagina);
	}
	
	
}
