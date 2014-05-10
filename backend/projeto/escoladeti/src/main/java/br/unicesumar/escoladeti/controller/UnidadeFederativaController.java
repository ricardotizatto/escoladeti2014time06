package br.unicesumar.escoladeti.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unicesumar.escoladeti.entity.UnidadeFederativa;
import br.unicesumar.escoladeti.service.UnidadeFederativaService;

@Controller
@RequestMapping(value="/rest/unidadeFederativaSource")
public class UnidadeFederativaController implements Serializable{
	private static final long serialVersionUID = 1L;
	@Autowired
	private UnidadeFederativaService federativaService;
	
	@RequestMapping(value="/unidadeFederativa", method= RequestMethod.POST)
	@ResponseBody
	public UnidadeFederativa salvar(@RequestBody UnidadeFederativa unidadeFederativa) {
		return this.federativaService.salvar(unidadeFederativa);
	}
	
	@RequestMapping(value="/unidadeFederativa", method= RequestMethod.DELETE)
	@ResponseBody
	public String deletar(@RequestBody UnidadeFederativa unidadeFederativa) {
		federativaService.deletar(unidadeFederativa);
		return "arquivo deletado";		
	}
	
	@RequestMapping(value="/unidadeFederativa", method= RequestMethod.GET)
	@ResponseBody
	public List<UnidadeFederativa> getTodos() {
		return this.federativaService.getTodos();
	}
	
	@RequestMapping(value= "/unidadeFederativa/{id}", method= RequestMethod.GET)
	@ResponseBody
	public UnidadeFederativa findById(@PathVariable Long id) {
		return this.federativaService.getById(id);
	}
	
	

}
