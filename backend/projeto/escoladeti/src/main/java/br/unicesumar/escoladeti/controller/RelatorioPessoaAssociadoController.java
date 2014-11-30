package br.unicesumar.escoladeti.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unicesumar.escoladeti.comando.ComandoRelatorioPessoaAssociado;
import br.unicesumar.escoladeti.service.RelatorioPessoaAssociadoService;

@Controller
@RequestMapping("/relatorio/associados")
public class RelatorioPessoaAssociadoController {

	@Autowired
	private RelatorioPessoaAssociadoService relatorioPessoaAssociadoService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public void imprimirRelatorio(
			@RequestParam(value = "dataInicio") String dataInicio,
			@RequestParam(value = "dataFim") String dataFim,
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "pago") String pago,
			HttpServletResponse response) throws IOException, JRException,
			SQLException {

		ComandoRelatorioPessoaAssociado comando = new ComandoRelatorioPessoaAssociado();
		comando.setDataFim(dataFim);
		comando.setDataInicio(dataInicio);
		comando.setId(id);
		comando.setPago(pago);
		this.relatorioPessoaAssociadoService.imprimir(comando, response);
	}
	// @RequestMapping(method = RequestMethod.GET)
	// @ResponseBody
	// public List<ViewPessoaAssociado> imprimirRelatorio(
	// @RequestParam(value = "dataInicio") String dataInicio,
	// @RequestParam(value = "dataFim") String dataFim,
	// @RequestParam(value = "nome") String nome,
	// @RequestParam(value = "pago") String pago
	// ){
	// ComandoRelatorioPessoaAssociado comando = new
	// ComandoRelatorioPessoaAssociado();
	// comando.setDataFim(dataFim);
	// comando.setDataInicio(dataInicio);
	// comando.setNome(nome);
	// comando.setPago(pago);
	// return this.relatorioPessoaAssociadoService.listar(comando);
	// }

}
