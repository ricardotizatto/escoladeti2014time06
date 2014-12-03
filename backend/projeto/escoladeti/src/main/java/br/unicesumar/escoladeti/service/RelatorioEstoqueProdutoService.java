package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoRelatorioEstoqueProduto;
import br.unicesumar.escoladeti.repository.ViewEstoqueProdutoRepository;
import br.unicesumar.escoladeti.view.ViewEstoqueProduto;
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

@Service
public class RelatorioEstoqueProdutoService {

    private static final String URL_REPORT = "br/unicesumar/escoladeti/reports/";
    private static final String NOME_ORIGEM_RELATORIO = "relatorioProduto.jasper";
    private static final String NOME_DESTINO_RELATORIO = "relatorioProduto.pdf";

    @Autowired
    private ViewEstoqueProdutoRepository estoqueProdutoRepository;
    
    public void imprimir(HttpServletResponse response){
        try {
            response.setHeader("Content-Disposition", "inline; filename=relatorioProduto.pdf");
            
            Map<String, Object> params = new HashMap<String, Object>();
            
            List<ViewEstoqueProduto> lista = this.estoqueProdutoRepository.findAll();

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);

            InputStream reportStream = new ClassPathResource(URL_REPORT + NOME_ORIGEM_RELATORIO).getInputStream();
            JasperPrint jp = JasperFillManager.fillReport(reportStream, params, dataSource);

            OutputStream out = response.getOutputStream();

            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);

            exporter.exportReport();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    
    
}
