package br.unicesumar.escoladeti.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unicesumar.escoladeti.comando.ComandoRelatorioEvento;
import br.unicesumar.escoladeti.service.RelatorioEventoService;

@Controller
@RequestMapping("/relatorio/eventos")
public class RelatorioEventoController {
	
	@Autowired
	private RelatorioEventoService relatorioEventoService;
	
//	@RequestMapping(method = RequestMethod.GET)
//	@ResponseBody
//	public List<ViewRelatorioEvento> getTodos(){
//		return this.relatorioEventoService.findAll();
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public void imprimirRelatorio(
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "tipo") String tipo,
			@RequestParam(value = "status") String status,
			@RequestParam(value = "dataInicio") String dataInicio,
			@RequestParam(value = "dataFim") String dataFim,
			HttpServletResponse response) throws IOException, JRException, SQLException{
		ComandoRelatorioEvento comando = new ComandoRelatorioEvento();
		comando.setId(id);
		comando.setTipo(tipo);
		comando.setStatus(status);
		comando.setDataInicio(dataInicio);
		comando.setDataFim(dataFim);
		this.relatorioEventoService.imprimir(comando,response);
	}
	
	@RequestMapping(value = "/comParticipantes", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> obterEventos(){
		return this.relatorioEventoService.findAll();
	}
	
	

}
