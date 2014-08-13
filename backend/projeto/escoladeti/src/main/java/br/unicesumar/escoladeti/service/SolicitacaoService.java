package br.unicesumar.escoladeti.service;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.unicesumar.escoladeti.comando.ComandoSalvarSolicitacao;
import br.unicesumar.escoladeti.comando.ComandoSalvarSolicitacaoItem;
import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.Livro;
import br.unicesumar.escoladeti.entity.Solicitacao;
import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import br.unicesumar.escoladeti.entity.Solicitacao.SolicitacaoBuilder;
import br.unicesumar.escoladeti.enums.StatusItem;
import br.unicesumar.escoladeti.enums.TraducaoMaterial;
import br.unicesumar.escoladeti.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService {
	
	@Autowired
	private SolicitacaoRepository solicitacaoRepository;
	
	public void deletar(Long id) {
		solicitacaoRepository.delete(id);		
	}

	public DataPage<Solicitacao> paginar(Integer pagina) {
		return new DataPage<>(solicitacaoRepository.findAll(pageRequestForAsc(pagina, "id")));
	}

	public Solicitacao buscar(Long id) {
		return solicitacaoRepository.findOne(id);
	}

	public Solicitacao salvar(ComandoSalvarSolicitacao comando) {
		SolicitacaoBuilder solicitacaoBuilder = Solicitacao
				.builder()
				.aluno(comando.getAluno())
				.cep(comando.getCep())
				.dataChegada(comando.getDataChegada())
				.endereco(comando.getEndereco())
				.escola(comando.getEscola())
				.municipio(comando.getMunicipio())
				.nre(comando.getNre())
				.numeroEndereco(comando.getNumeroEndereco())
				.responsavel(comando.getResponsavel())
				.serie(comando.getSerie());
		
		
		List<SolicitacaoItem> itens = new ArrayList<SolicitacaoItem>();
		
		for (ComandoSalvarSolicitacaoItem comandoItem: comando.getItensSolicitacao()) {
			SolicitacaoItem solicitacaoItem = SolicitacaoItem
					.builder()
					.livro(comandoItem.getLivro())
					.outro(comandoItem.getOutro())
					.traducaoMaterial(comandoItem.getTraducaoMaterial())
					.status(StatusItem.ABERTO)
					.build();
			itens.add(solicitacaoItem);
		}
		
		Solicitacao solicitacao = solicitacaoBuilder
				.itensSolicitacao(itens)
				.build();
		
		return solicitacaoRepository.save(solicitacao);
	}

	public List<Solicitacao> listar() {
		return solicitacaoRepository.findAll();
	}
	
	
}
