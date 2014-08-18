package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.comando.ComandoSalvarPessoa;
import br.unicesumar.escoladeti.entity.Pessoa;
import br.unicesumar.escoladeti.entity.PessoaFisica;
import br.unicesumar.escoladeti.service.PessoaService;
import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/pessoas")
public class PessoaController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PessoaService pessoaService;	
	
    
	@RequestMapping( method = RequestMethod.POST)	
	@ResponseBody
	public Pessoa salvar(@Valid @RequestBody ComandoSalvarPessoa comando) {		
		return pessoaService.salvar(comando);
	}
    
	@RequestMapping( value= {"/{id}"}, method = RequestMethod.GET )
	@ResponseBody
	public Pessoa getPessoa(@PathVariable Long id) {
		return pessoaService.buscar(id);
	}
	
	@RequestMapping(value = { "/paginar/{pagina}" }, method = RequestMethod.GET)
	@ResponseBody
	public DataPage<PessoaFisica> paginar(@PathVariable Integer pagina) {
		return pessoaService.paginar(pagina);
	}
}
