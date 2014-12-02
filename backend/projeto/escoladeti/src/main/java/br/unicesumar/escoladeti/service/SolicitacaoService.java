package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoSalvarSolicitacao;
import br.unicesumar.escoladeti.comando.ComandoSalvarSolicitacaoItem;
import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.*;
import br.unicesumar.escoladeti.enums.StatusItem;
import br.unicesumar.escoladeti.repository.*;
import br.unicesumar.escoladeti.util.number.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private VolumeRepository volumeRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private SolicitacaoVolumeRepository solicitacaoVolumeRepository;

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
                .cep(comando.getEnderecoCep())
                .dataChegada(comando.getDataChegada())
                .escola(comando.getEscola())
                .ensino(comando.getEnsino())
                .municipio(comando.getEnderecoMunicipio())
                .nre(comando.getNre())
                .responsavel(comando.getResponsavel())
                .serie(comando.getSerie())
                .bairro(comando.getEnderecoBairro())
                .endereco(comando.getEnderecoLogradouro())
                .numeroEndereco(comando.getEnderecoNumero())
                .tipo(comando.getEnderecoTipo())
                .complemento(comando.getEnderecoComplemento())
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

         Solicitacao solicitacao = Solicitacao
                .builder()
                .id(id)
                .aluno(comando.getAluno())
                .cep(comando.getEnderecoCep())
                .dataChegada(comando.getDataChegada())
                .escola(comando.getEscola())
                .ensino(comando.getEnsino())
                .municipio(comando.getEnderecoMunicipio())
                .nre(comando.getNre())
                .responsavel(comando.getResponsavel())
                .serie(comando.getSerie())
                .bairro(comando.getEnderecoBairro())
                .endereco(comando.getEnderecoLogradouro())
                .numeroEndereco(comando.getEnderecoNumero())
                .tipo(comando.getEnderecoTipo())
                .complemento(comando.getEnderecoComplemento())
                .build();

        Solicitacao solicitacaoSalva = solicitacaoRepository.save(solicitacao);

        for (ComandoSalvarSolicitacaoItem comandoItem: comando.getItensSolicitacao()) {

            if (comandoItem.getId() != null) {
                SolicitacaoItem solicitacaoItemEncontrado = solicitacaoItemRepository.findOne(comandoItem.getId());


                if (solicitacaoItemEncontrado != null
                        && (solicitacaoItemEncontrado.possuiSolicitavaoVolumes()
                        || solicitacaoItemEncontrado.getStatus().equals(StatusItem.CANCELADO))) {
                    continue;
                }

                solicitacaoItemRepository.delete(solicitacaoItemEncontrado);
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
