package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.Participante;
import br.unicesumar.escoladeti.repository.EventoRepository;
import br.unicesumar.escoladeti.repository.ParticipanteRepository;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelatorioParticipanteService {

    private static final String URL_REPORT = "src/main/resources/br/unicesumar/escoladeti/reports/";
    
    @Autowired
    private ParticipanteRepository participanteRepository;
    
    @Autowired
    private EventoRepository eventoRepository;

    public void imprimirRelatorio(Long idevento) {
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        try {
            jasperReport = JasperCompileManager.compileReport(URL_REPORT + "participantesPorEvento.jrxml");

            List<Participante> participantes = participanteRepository.findByIdevento(idevento);
            
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("nomeEvento", eventoRepository.findById(idevento).getTitulo());
            
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource (participantes);

            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, URL_REPORT + "participantesPorEvento.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
