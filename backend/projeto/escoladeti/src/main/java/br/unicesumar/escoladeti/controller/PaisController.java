package br.unicesumar.escoladeti.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unicesumar.escoladeti.entity.Pais;
import br.unicesumar.escoladeti.exceptions.InconsistenciaException;
import br.unicesumar.escoladeti.service.PaisService;

@Controller
@RequestMapping("/rest/paisSource")
public class PaisController implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private PaisService paisService;

	@RequestMapping(value = "/pais", method = RequestMethod.POST)
	@ResponseBody
	public Pais salvar(@RequestBody Pais pais) {
		return paisService.salvar(pais);
	}

	@RequestMapping(value = "/pais", method = RequestMethod.PUT)
	@ResponseBody
	public Pais editar(@RequestBody Pais pais) {
		Pais paisEditado = this.paisService.getById(pais.getId());
		System.out.println("Pais " + pais.getId());
		return paisService.salvar(paisEditado);
	}

	@RequestMapping(value = "/pais/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Pais getById(@PathVariable Long id) {
		return paisService.getById(id);
	}

	@RequestMapping(value = "/pais", method = RequestMethod.GET)
	@ResponseBody
	public DataPage<Pais> getTodos() {
		return paisService.getTodos(1);
	}

	@RequestMapping(value = { "/listar/pag/{pagina}" }, method = RequestMethod.GET)
	@ResponseBody
	public DataPage<Pais> listarPais(@PathVariable Integer pagina) {
		return paisService.getTodos(pagina);
	}

	@RequestMapping(value = "/pais", method = RequestMethod.DELETE)
	@ResponseBody
	public String deletar(@RequestBody Pais pais) {
		paisService.deletar(pais);
		return "deleted";
	}

}
