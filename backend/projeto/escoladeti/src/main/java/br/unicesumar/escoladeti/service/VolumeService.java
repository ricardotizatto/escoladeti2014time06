package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoAlterarData;
import br.unicesumar.escoladeti.comando.ComandoMarcarRevisado;
import br.unicesumar.escoladeti.comando.ComandoSalvarVolume;
import br.unicesumar.escoladeti.entity.PessoaFisica;
import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import br.unicesumar.escoladeti.entity.Usuario;
import br.unicesumar.escoladeti.entity.Volume;
import br.unicesumar.escoladeti.enums.VolumeStatus;
import br.unicesumar.escoladeti.repository.SolicitacaoItemRepository;
import br.unicesumar.escoladeti.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jhonatan on 16/09/2014.
 */
@Service
public class VolumeService {

    @Autowired
    private VolumeRepository volumeRepository;

    @Autowired
    private SolicitacaoItemRepository solicitacaoItemRepository;

    public void deletar(Long id) {
        Volume volume = volumeRepository.findOne(id);

        if (volume.getStatus().equals(VolumeStatus.ENVIADO)) {
            throw new RuntimeException("Volume enviado não pode ser deletado");
        }
        volumeRepository.delete(id);
    }

    @Transactional
    public Volume marcarComoImprimido(Long id, ComandoSalvarVolume comandoSalvarVolume) {
        Volume volume = volumeRepository.findOne(id);
        volume.marcarComoImprimido(comandoSalvarVolume);
        Volume volumeSalvo = volumeRepository.save(volume);
        return volumeSalvo;
    }

    @Transactional
    public Volume marcarComoRevisado(Long id, ComandoSalvarVolume comando) {
        Volume volume = volumeRepository.findOne(id);

        volume.marcarComoRevisado(comando.getDataAsDate(), comando.getRevisor(), comando.getObservacao());
        return volumeRepository.save(volume);
    }

    @Transactional
    public Volume marcarComoEnviado(Long id, ComandoSalvarVolume comando) {
        Volume volume = volumeRepository.findOne(id);
        volume.marcarComoEnviado(comando.getDataAsDate(), comando.getObservacao());
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

        SolicitacaoItem solicitacaoItem = solicitacaoItemRepository.findOne(volume.getIdSolicitacaoItem());

        solicitacaoItem.validarPaginas(comandoSalvarVolume.getPaginaInicio(), comandoSalvarVolume.getPaginaFim());

        volume.setStatus(VolumeStatus.ANDAMENTO);
        return  volumeRepository.save(volume);
    }

    private Volume montarVolume(ComandoSalvarVolume comandoSalvarVolume) {
        Volume volume = new Volume();
        volume.setIdSolicitacaoItem(comandoSalvarVolume.getIdSolicitacaoItem());
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
        volume.setDataEnviado(volumeSalvo.getDataEnviado());
        volume.setDataImpressao(volume.getDataImpressao());
        volume.setDataEnviado(volumeSalvo.getDataEnviado());
        return volumeRepository.save(volume);
    }


    public Volume buscar(Long idVolume) {
        return volumeRepository.findOne(idVolume);
    }
}
