package br.unicesumar.escoladeti.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
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

import br.unicesumar.escoladeti.dto.RelatorioProducaoDTO;
import br.unicesumar.escoladeti.entity.Participante;
import br.unicesumar.escoladeti.repository.RelatorioProducaoSolicitanteRepository;
import br.unicesumar.escoladeti.repository.RelatorioProducaoVolumeRepository;
import br.unicesumar.escoladeti.view.ViewRelatorioProducaoSolicitante;

@Service
public class RelatorioProducaoService {
	
	private static final String URL_REPORT = "br/unicesumar/escoladeti/reports/";
	private static final String NOME_ORIGEM_RELATORIO = "relatorioProducao.jasper";
	private static final String NOME_DESTINO_RELATORIO = "relatorioProducao.pdf";	
	
	@Autowired
	private RelatorioProducaoVolumeRepository relatorioProducaoVolumeRepository;
	
	@Autowired
	private RelatorioProducaoSolicitanteRepository relatorioProducaoSolicitanteRepository;

	public RelatorioProducaoDTO obterRelatorio() {
		RelatorioProducaoDTO relatorioProducao = new RelatorioProducaoDTO();
//		relatorioProducao.setSolicitantes(this.relatorioProducaoSolicitanteRepository.findAll());
		relatorioProducao.setVolumes(this.relatorioProducaoVolumeRepository.findAll());
		return relatorioProducao;
	}

	public void imprimir(HttpServletResponse response) throws IOException, JRException, SQLException{
        try {
            response.setHeader("Content-Disposition", "inline; filename=participantes.pdf");

            HashMap<String, Object> params = new HashMap<>();
            params.put("nomeAlunoe", relatorioProducaoSolicitanteRepository.findOne(182L).getAluno());
            List<RelatorioProducaoDTO> relatorio = new ArrayList<RelatorioProducaoDTO>();

            for (ViewRelatorioProducaoSolicitante participante : this.relatorioProducaoSolicitanteRepository.findAll()) {
            	RelatorioProducaoDTO dados = new RelatorioProducaoDTO();
            	dados.setAluno(participante.getAluno());
            	dados.setBairro(participante.getBairro());
            	dados.setCep(participante.getCep());
            	dados.setEndereco(participante.getEndereco());            	
            	dados.setComplemento(participante.getComplemento());
            	dados.setEmail(participante.getEmail());
            	dados.setEnsino(participante.getEnsino());
            	dados.setEscola(participante.getEscola());
            	dados.setId(participante.getId());
            	dados.setIdade(participante.getIdade());
            	dados.setMunicipioUf(participante.getMunicipioUf());
            	dados.setNascimentoCriacao(participante.getNascimentoCriacao());
            	dados.setNre(participante.getNre());
            	dados.setResponsavel(participante.getResponsavel());
            	dados.setTelefone(participante.getTelefone());
            	dados.setDatachegada(participante.getDatachegada());
            	
            	dados.setVolumes(this.relatorioProducaoVolumeRepository.findBySolicitacaoid(dados.getId()));
            	relatorio.add(dados);
			}
            
    		
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(relatorio);

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
