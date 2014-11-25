package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.vo.VoRelatorioTeste;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.junit.Test;

/**
 *
 * @author Alisson
 */
public class TesteRelatorioEvento {

    private static final String URL_REPORT = "src/main/resources/br/unicesumar/escoladeti/reports/";

//    @Test
    public void testarImpressaoRelatorioEvento() {
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        try {
            jasperReport = JasperCompileManager.compileReport(URL_REPORT + "relatorioTeste.jrxml");

            Map<String, Object> parameters = new HashMap<>();
            List<VoRelatorioTeste> participantes = new ArrayList<>();
            preencherListaParticipantes(participantes);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource (participantes);

            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, URL_REPORT + "relatorio.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherListaParticipantes(List<VoRelatorioTeste> participantes) {

        for (int i = 0; i < 10; i++) {
            VoRelatorioTeste p = new VoRelatorioTeste();
            p.setNome("NOME " + i);
            p.setCpf("069.454.109.5" + i);
            p.setDataNascimento("2" + i + "/05/1993");
            
            participantes.add(p);
        }
    }
}
