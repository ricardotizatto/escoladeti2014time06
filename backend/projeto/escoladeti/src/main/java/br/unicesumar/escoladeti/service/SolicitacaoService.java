package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoSalvarSolicitacao;
import br.unicesumar.escoladeti.comando.ComandoSalvarSolicitacaoItem;
import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.Livro;
import br.unicesumar.escoladeti.entity.Solicitacao;
import br.unicesumar.escoladeti.entity.Solicitacao.SolicitacaoBuilder;
import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import br.unicesumar.escoladeti.enums.StatusItem;
import br.unicesumar.escoladeti.repository.LivroRepository;
import br.unicesumar.escoladeti.repository.SolicitacaoItemRepository;
import br.unicesumar.escoladeti.repository.SolicitacaoRepository;
import br.unicesumar.escoladeti.util.number.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private SolicitacaoItemRepository solicitacaoItemRepository;


    @Autowired
    private LivroRepository livroRepository;

    public void deletar(Long id) {
        solicitacaoRepository.delete(id);
    }

    public DataPage<Solicitacao> paginar(Integer pagina, String termo) {
        if (termo != null && NumberUtils.isNumber(termo)) {
            return new DataPage<>(solicitacaoRepository.findByIdOrderByIdAsc(
                    Long.parseLong(termo), pageRequestForAsc(pagina, "id")));
        }

        return new DataPage<>(solicitacaoRepository.findAll(pageRequestForAsc(pagina, "id")));
    }

    public Solicitacao buscar(Long id) {
        return solicitacaoRepository.findOne(id);
    }

    @Transactional
    public Solicitacao salvar(ComandoSalvarSolicitacao comando) {
        Solicitacao solicitacao = Solicitacao
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
                .serie(comando.getSerie())
                .build();

        Solicitacao solicitacaoSalva = solicitacaoRepository.save(solicitacao);

        for (ComandoSalvarSolicitacaoItem comandoItem: comando.getItensSolicitacao()) {

            SolicitacaoItem solicitacaoItem = SolicitacaoItem
                    .builder()
                    .livro(Livro.of(comandoItem.getLivro()))
                    .outro(comandoItem.getOutro())
                    .traducaoMaterial(comandoItem.getTraducaoMaterial())
                    .status(StatusItem.ANDAMENTO)
                    .solicitacao(solicitacao)
                    .build();

            solicitacaoItemRepository.save(solicitacaoItem);
        }

        return solicitacaoRepository.findOne(solicitacaoSalva.getId());
    }

    @Transactional
    public Solicitacao atualizar(Long id, ComandoSalvarSolicitacao comando) throws Exception {
        Solicitacao solicitacaoEncontrada = solicitacaoRepository.findOne(id);
        limparItens(solicitacaoEncontrada);

         Solicitacao solicitacao = Solicitacao
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
                .serie(comando.getSerie())
                .build();

        Solicitacao solicitacaoSalva = solicitacaoRepository.save(solicitacao);

        for (ComandoSalvarSolicitacaoItem comandoItem: comando.getItensSolicitacao()) {

            if (comandoItem.getId() != null) {
                SolicitacaoItem solicitacaoItemEncontrado = solicitacaoItemRepository.findOne(comandoItem.getId());

                if (solicitacaoItemEncontrado != null && solicitacaoItemEncontrado.possuiSolicitavaoVolumes()) {
                    continue;
                }
            }

            SolicitacaoItem solicitacaoItem = SolicitacaoItem
                    .builder()
                    .id(comandoItem.getId())
                    .livro(Livro.of(comandoItem.getLivro()))
                    .outro(comandoItem.getOutro())
                    .status(StatusItem.ANDAMENTO)
                    .traducaoMaterial(comandoItem.getTraducaoMaterial())
                    .solicitacao(solicitacaoSalva)
                    .build();

            solicitacaoItemRepository.save(solicitacaoItem);
        }


        return solicitacaoRepository.findOne(id);
    }

    private void limparItens(Solicitacao solicitacao) {
        for (SolicitacaoItem item : solicitacao.getItensSolicitacao()) {
            if (!item.possuiSolicitavaoVolumes()) {
                solicitacaoItemRepository.delete(item);
            }
        }
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
