package br.unicesumar.escoladeti.controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import br.unicesumar.escoladeti.comando.ComandoSalvarSolicitacao;
import br.unicesumar.escoladeti.entity.Solicitacao;
import br.unicesumar.escoladeti.service.SolicitacaoService;

@Controller
@RequestMapping("/rest/solicitacoes")
public class SolicitacaoController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SolicitacaoService solicitacaoService;


    @Transactional
	@RequestMapping( method = RequestMethod.POST)	
	@ResponseBody
	public Solicitacao salvar(@Valid @RequestBody ComandoSalvarSolicitacao comando) {		
		return solicitacaoService.salvar(comando);
	}

    @Transactional
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Solicitacao atualizar(@Valid @RequestBody ComandoSalvarSolicitacao comando,
		@PathVariable("id") Long id) throws Exception {
		return solicitacaoService.atualizar(id, comando);
	}
    
	@RequestMapping(method = RequestMethod.GET)	
	@ResponseBody
	public List<Solicitacao> retornarTodos() {
		return solicitacaoService.listar();
	}
	
	@RequestMapping( value= {"/{id}"}, method = RequestMethod.GET )
	@ResponseBody
	public Solicitacao getSolicitacao(@PathVariable Long id ) {
		return solicitacaoService.buscar(id);
	}
	
	@RequestMapping(value = { "/paginar/{pagina}" }, method = RequestMethod.GET)
	@ResponseBody
	public DataPage<Solicitacao> paginar(@PathVariable Integer pagina,
                                         @RequestParam(required = false, value = "termo") String termo) {
        return solicitacaoService.paginar(pagina, termo);
    }


}
