package br.unicesumar.escoladeti.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unicesumar.escoladeti.entity.Caracteristica;
import br.unicesumar.escoladeti.service.CaracteristicaService;


@Controller
@RequestMapping(value = "/rest/caracteristica")
public class CaracteristicaController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CaracteristicaService caracteristicaService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Caracteristica> getTodas(){
		return this.caracteristicaService.findAll();
	}

}
