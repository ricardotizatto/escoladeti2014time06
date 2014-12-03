package br.unicesumar.escoladeti.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import br.unicesumar.escoladeti.comando.ComandoRelatorioEvento;
import br.unicesumar.escoladeti.repository.EventoRepository;
import br.unicesumar.escoladeti.repository.RelatorioEventoRepository;
import br.unicesumar.escoladeti.view.ViewRelatorioEvento;

@Service
public class RelatorioEventoService {

	private static final String URL_REPORT = "br/unicesumar/escoladeti/reports/";
	private static final String NOME_ORIGEM_RELATORIO = "relatorioEvento.jasper";
	private static final String NOME_DESTINO_RELATORIO = "relatorioEvento.pdf";

	@Autowired
	private RelatorioEventoRepository relatorioEventoRepository;

	@Autowired
	private EventoRepository eventoService;

	public List<Map<String, Object>> findAll() {
		List<Object[]> titulosIdsDosEventos = this.relatorioEventoRepository
				.obterTitulosIdsDosEventos();
		List<Map<String, Object>> mapaParaJson = new ArrayList<Map<String, Object>>();
		for (Object[] obj : titulosIdsDosEventos) {

			Map<String, Object> mapa = new HashMap<String, Object>();
			mapa.put("id", obj[0]);
			mapa.put("titulo", obj[1]);
			mapaParaJson.add(mapa);
		}
		return mapaParaJson;
	}

	public void imprimir(ComandoRelatorioEvento comando,
			HttpServletResponse response) {
		try {
			response.setHeader("Content-Disposition",
					"inline; filename=eventos.pdf");
			String titulo = "TODOS";
			if (comando.getId() != null && comando.getId() != 0L) {
				titulo = this.eventoService.findOne(comando.getId())
						.getTitulo();
			}

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("filtroTitulo", titulo);
			params.put("filtroTipo", comando.getTipo());
			params.put("filtroStatus", comando.getStatus());
			params.put("filtroDataInicio", comando.getDataInicio());
			params.put("filtroDataFim", comando.getDataFim());

			List<ViewRelatorioEvento> lista = this.relatorioEventoRepository
					.findByIdAndTipoContainingAndStatusContainingAndDataBetween(
							comando.getId(), comando.getTipo(),
							comando.getStatus(), comando.getDataInicio(),
							comando.getDataFim());

			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(
					lista);

			InputStream reportStream = new ClassPathResource(URL_REPORT
					+ NOME_ORIGEM_RELATORIO).getInputStream();
			JasperPrint jp = JasperFillManager.fillReport(reportStream, params,
					dataSource);

			OutputStream out = response.getOutputStream();

			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);

			exporter.exportReport();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}

	}

}
