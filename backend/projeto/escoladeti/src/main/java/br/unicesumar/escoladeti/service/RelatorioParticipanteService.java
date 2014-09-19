package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.Participante;
import br.unicesumar.escoladeti.repository.EventoRepository;
import br.unicesumar.escoladeti.repository.ParticipanteRepository;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
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

@Service
public class RelatorioParticipanteService {

    private static final String URL_REPORT = "br/unicesumar/escoladeti/reports/";
    private static final String NOME_ORIGEM_RELATORIO = "participantesPorEvento.jasper";
    private static final String NOME_DESTINO_RELATORIO = "participantesPorEvento.pdf";

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private EventoRepository eventoRepository;

    public void imprimir(Long id, HttpServletResponse response) throws IOException, JRException, SQLException {
        
        try {
            response.setHeader("Content-Disposition", "inline; filename=participantes.pdf");

            HashMap<String, Object> params = new HashMap<>();
            params.put("nomeEvento", eventoRepository.findById(id).getTitulo());

            List<Participante> participantes = participanteRepository.findByIdevento(id);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(participantes);

            InputStream reportStream = new ClassPathResource(URL_REPORT + NOME_ORIGEM_RELATORIO).getInputStream();

            JasperPrint jp = JasperFillManager.fillReport(reportStream, params, dataSource);

            OutputStream out = response.getOutputStream();

            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);

            exporter.exportReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
