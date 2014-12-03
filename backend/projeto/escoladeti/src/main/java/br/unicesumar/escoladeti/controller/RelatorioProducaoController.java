package br.unicesumar.escoladeti.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unicesumar.escoladeti.dto.RelatorioProducaoDTO;
import br.unicesumar.escoladeti.service.RelatorioProducaoService;

@RequestMapping(value = "/relatorio/producao")
@Controller
public class RelatorioProducaoController {
	
	@Autowired
	private RelatorioProducaoService relatorioProducaoService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public RelatorioProducaoDTO obterRelatorio(){
		return this.relatorioProducaoService.obterRelatorio();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/imprimir")
	@ResponseBody
	public void imprimir(HttpServletResponse response) throws IOException, JRException, SQLException{
		this.relatorioProducaoService.imprimir(response);
	}
	
	

}
