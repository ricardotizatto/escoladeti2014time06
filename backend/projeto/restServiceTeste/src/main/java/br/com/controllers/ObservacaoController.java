package br.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.entity.Observacao;
import br.com.repository.ObservacaoRepository;

@Controller
@RequestMapping("/observacao")
public class ObservacaoController {
	@Autowired
	private ObservacaoRepository observacaoRepository;

	@RequestMapping(value="/novo", method=RequestMethod.POST)
	public @ResponseBody Observacao novaObservacao(@RequestBody Observacao observacao) {
		System.out.println(observacao);
		Observacao novaObservacao = observacaoRepository.save(observacao);
		return novaObservacao;
	}
	
	@RequestMapping(value="/todos", method=RequestMethod.GET)
	public @ResponseBody List<Observacao> retornaTodos() {
		return observacaoRepository.findAll();
	}
	
}
