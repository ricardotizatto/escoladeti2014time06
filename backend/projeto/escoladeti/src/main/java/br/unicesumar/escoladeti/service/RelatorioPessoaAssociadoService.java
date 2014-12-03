package br.unicesumar.escoladeti.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

import br.unicesumar.escoladeti.comando.ComandoRelatorioPessoaAssociado;
import br.unicesumar.escoladeti.repository.ViewPessoaAssociadoRepository;
import br.unicesumar.escoladeti.view.ViewPessoaAssociado;

@Service
public class RelatorioPessoaAssociadoService {

	private static final String URL_REPORT = "br/unicesumar/escoladeti/reports/";
	private static final String NOME_ORIGEM_RELATORIO = "relatorioAssociado.jasper";
	private static final String NOME_DESTINO_RELATORIO = "relatorioAssociado.pdf";

	@Autowired
	private ViewPessoaAssociadoRepository viewPessoaAssociadoRepository;

	public void imprimir(ComandoRelatorioPessoaAssociado comando,
			HttpServletResponse response) {

		try {
			response.setHeader("Content-Disposition",
					"inline; filename=associados.pdf");
			String nome = "TODOS";
			if (comando.getId() != null && comando.getId() != 0L) {
				nome = this.viewPessoaAssociadoRepository.findOne(
						comando.getId()).getNome();
			}

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("filtroNome", nome);
			params.put("filtroPago", comando.getPago());
			params.put("filtroDataInicio", comando.getDataInicio());
			params.put("filtroDataFim", comando.getDataFim());

			List<ViewPessoaAssociado> lista = this.viewPessoaAssociadoRepository
					.findByVigenciaBetweenAndIdAndPagoContainingOrderByNomeAscAndVigenciaAsc(
							comando.getDataInicio(), comando.getDataFim(),
							comando.getId(), comando.getPago());

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
