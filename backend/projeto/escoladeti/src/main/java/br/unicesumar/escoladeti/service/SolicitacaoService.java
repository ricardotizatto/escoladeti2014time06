package br.unicesumar.escoladeti.service;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;

import java.util.ArrayList;
import java.util.List;

import br.unicesumar.escoladeti.entity.Livro;
import br.unicesumar.escoladeti.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unicesumar.escoladeti.comando.ComandoSalvarSolicitacao;
import br.unicesumar.escoladeti.comando.ComandoSalvarSolicitacaoItem;
import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.Solicitacao;
import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import br.unicesumar.escoladeti.entity.Solicitacao.SolicitacaoBuilder;
import br.unicesumar.escoladeti.enums.StatusItem;
import br.unicesumar.escoladeti.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService {
	
	@Autowired
	private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private LivroRepository livroRepository;
	
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
				.ensino(comando.getEnsino())
				.municipio(comando.getMunicipio())
				.nre(comando.getNre())
				.numeroEndereco(comando.getNumeroEndereco())
				.responsavel(comando.getResponsavel())
				.serie(comando.getSerie());
		
		
		List<SolicitacaoItem> itens = new ArrayList<SolicitacaoItem>();
		
		for (ComandoSalvarSolicitacaoItem comandoItem: comando.getItensSolicitacao()) {
            Livro livro = livroRepository.findById(comandoItem.getLivro());

            if (livro == null) {
                throw new RuntimeException("Livro não encontrado.");
            }

			SolicitacaoItem solicitacaoItem = SolicitacaoItem
					.builder()
					.livro(livro)
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
	
	public Solicitacao atualizar(Long id, ComandoSalvarSolicitacao comando) throws Exception {
		SolicitacaoBuilder solicitacaoBuilder = Solicitacao
				.builder()
				.id(id)
				.aluno(comando.getAluno())
				.cep(comando.getCep())
				.dataChegada(comando.getDataChegada())
				.endereco(comando.getEndereco())
				.ensino(comando.getEnsino())

				.escola(comando.getEscola())
				.municipio(comando.getMunicipio())
				.nre(comando.getNre())
				.numeroEndereco(comando.getNumeroEndereco())
				.responsavel(comando.getResponsavel())
				.serie(comando.getSerie());
		
		
		List<SolicitacaoItem> itens = new ArrayList<SolicitacaoItem>();
		
		for (ComandoSalvarSolicitacaoItem comandoItem: comando.getItensSolicitacao()) {
            Livro livro = livroRepository.findById(comandoItem.getLivro());

            if (livro == null) {
                throw new RuntimeException("Livro não encontrado.");
            }

			SolicitacaoItem solicitacaoItem = SolicitacaoItem
					.builder()
					.livro(livro)
					.outro(comandoItem.getOutro())
					.traducaoMaterial(comandoItem.getTraducaoMaterial())
					.status(StatusItem.ABERTO)
					.build();

            validarDuplicados(itens, solicitacaoItem);

			itens.add(solicitacaoItem);
		}
		
		Solicitacao solicitacao = solicitacaoBuilder
				.itensSolicitacao(itens)
				.build();
		
		return solicitacaoRepository.save(solicitacao);
		
		
	}

    private void validarDuplicados(List<SolicitacaoItem> itens, SolicitacaoItem solicitacaoItem) throws Exception {
        for (SolicitacaoItem item : itens) {
            if (item.equals(solicitacaoItem)) {
                throw new RuntimeException("Só pode existir um livro para um tipo de tradução.");
            }
        }
    }

    public List<Solicitacao> listar() {
		return solicitacaoRepository.findAll();
	}
	
}
