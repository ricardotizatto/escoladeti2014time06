package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoSalvarVolume;
import br.unicesumar.escoladeti.entity.*;
import br.unicesumar.escoladeti.enums.Transcricao;
import br.unicesumar.escoladeti.enums.VolumeStatus;
import br.unicesumar.escoladeti.repository.SolicitacaoItemRepository;
import br.unicesumar.escoladeti.repository.SolicitacaoVolumeRepository;
import br.unicesumar.escoladeti.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jhonatan on 16/09/2014.
 */
@Service
public class VolumeService {

    @Autowired
    private VolumeRepository volumeRepository;

    @Autowired
    private SolicitacaoItemRepository solicitacaoItemRepository;

    @Autowired
    private SolicitacaoVolumeRepository solicitacaoVolumeRepository;

    public void deletar(Long id) {
        Volume volume = volumeRepository.findOne(id);

        if (volume.getStatus().equals(VolumeStatus.REVISADO)) {
            throw new RuntimeException("Volume revisado não pode ser deletado");
        }
        SolicitacaoVolume solicitacaoVolume = solicitacaoVolumeRepository.findByVolumeId(volume.getId());

        solicitacaoVolumeRepository.delete(solicitacaoVolume);
        volumeRepository.delete(id);
    }

    @Transactional
    public Volume marcarComoImprimido(Long id, ComandoSalvarVolume comandoSalvarVolume) {
        Volume volume = volumeRepository.findOne(id);
        volume.marcarComoImpresso(comandoSalvarVolume);
        Volume volumeSalvo = volumeRepository.save(volume);
        return volumeSalvo;
    }

    @Transactional
    public Volume concluir(Long id, ComandoSalvarVolume comandoSalvarVolume) {
        atualizarVolume(id, comandoSalvarVolume);
        Volume volume = volumeRepository.findOne(id);
        volume.concluir(comandoSalvarVolume);
        volumeRepository.save(volume);
        return volume;
    }

    @Transactional
    public Volume marcarComoRevisado(Long id, ComandoSalvarVolume comando) {
        Volume volume = volumeRepository.findOne(id);
        atualizarVolume(id, comando);
        volume.marcarComoRevisado(comando.getDataAsDate(), comando.getRevisor(), comando.getObservacao());
        return volumeRepository.save(volume);
    }

    @Transactional
    public Volume rejeitar(Long id, ComandoSalvarVolume comando) {
        Volume volume = volumeRepository.findOne(id);
        volume.rejeitar(comando.getDataAsDate(), comando.getRevisor(), comando.getObservacao());
        return volumeRepository.save(volume);
    }

    @Transactional
    public Volume reativar(Long id) {
        Volume volume = volumeRepository.findOne(id);
        volume.reativar();
        return volumeRepository.save(volume);
    }

    @Transactional
    public Volume criarVolume(ComandoSalvarVolume comandoSalvarVolume) {
        Volume volume = montarVolume(comandoSalvarVolume);

        if (volume.getPaginaFim() <= volume.getPaginaInicio()) {
            throw new RuntimeException("Pagina final deve ser maior que paginá inicial");
        }

        if (volume.getPaginaInicio() < 0 ) {
            throw new RuntimeException("Página inicial deve ser maior que 0");
        }

        SolicitacaoItem solicitacaoItem = solicitacaoItemRepository.findOne(comandoSalvarVolume.getIdSolicitacaoItem());
        Livro livro = solicitacaoItem.getLivro();

        livro.validarPaginas(comandoSalvarVolume.getPaginaInicio(),
                comandoSalvarVolume.getPaginaFim(),
                solicitacaoItem.getTraducaoMaterial());

        volume.setTranscricao(solicitacaoItem.getTraducaoMaterial());
        volume.setStatus(VolumeStatus.ANDAMENTO);
        volume.setIdLivro(solicitacaoItem.getLivro().getId());
        volumeRepository.save(volume);

        SolicitacaoVolume solicitacaoVolume = new SolicitacaoVolume();
        solicitacaoVolume.setIdSolicitacaoItem(comandoSalvarVolume.getIdSolicitacaoItem());
        solicitacaoVolume.setVolume(volume);
        solicitacaoVolumeRepository.save(solicitacaoVolume);

        atualizarSolicitacaoItens(livro.getId(), solicitacaoItem.getTraducaoMaterial(), volume, solicitacaoItem.getId());

        return volume;
    }


    private void atualizarSolicitacaoItens(Long idLivro, Transcricao transcricao, Volume volume, Long idSolicitacaoItem) {
        List<SolicitacaoItem> solicitacaoItems = solicitacaoItemRepository.findByLivroIdAndTraducaoMaterial(idLivro, transcricao);

        for (SolicitacaoItem solicitacaoItem : solicitacaoItems) {

            if (solicitacaoItem.getId().equals(idSolicitacaoItem)) {
                continue;
            }

            SolicitacaoVolume solicitacaoVolume = solicitacaoItem.gerarSolicitacaoVolume(volume);
            solicitacaoVolumeRepository.save(solicitacaoVolume);
        }
    }

    private Volume montarVolume(ComandoSalvarVolume comandoSalvarVolume) {
        Volume volume = new Volume();
        volume.setObservacao(comandoSalvarVolume.getObservacao());
        volume.setPaginaFim(comandoSalvarVolume.getPaginaFim());
        volume.setPaginaInicio(comandoSalvarVolume.getPaginaInicio());
        volume.setResponsavel(Usuario.of(comandoSalvarVolume.getResponsavel()));
        return volume;
    }

    @Transactional
    public Volume atualizarVolume( Long id, ComandoSalvarVolume comandoSalvarVolume) {

        Volume volumeSalvo = volumeRepository.findOne(id);
        Volume volume = montarVolume(comandoSalvarVolume);
        volume.setId(id);
        volume.setStatus(volumeSalvo.getStatus());
        volume.setIdLivro(volumeSalvo.getIdLivro());
        volume.setDataEnviado(volumeSalvo.getDataEnviado());
        volume.setCaminhoAnexo(volumeSalvo.getCaminhoAnexo());
        volume.setTranscricao(volumeSalvo.getTranscricao());
        volume.setDataEnviado(volumeSalvo.getDataEnviado());
        return volumeRepository.save(volume);
    }


    public Volume buscar(Long idVolume) {
        return volumeRepository.findOne(idVolume);
    }
}
