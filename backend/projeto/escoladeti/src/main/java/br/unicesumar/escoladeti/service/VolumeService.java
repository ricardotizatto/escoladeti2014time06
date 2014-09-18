package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoAlterarData;
import br.unicesumar.escoladeti.comando.ComandoMarcarRevisado;
import br.unicesumar.escoladeti.comando.ComandoSalvarVolume;
import br.unicesumar.escoladeti.entity.PessoaFisica;
import br.unicesumar.escoladeti.entity.Usuario;
import br.unicesumar.escoladeti.entity.Volume;
import br.unicesumar.escoladeti.enums.VolumeStatus;
import br.unicesumar.escoladeti.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jhonatan on 16/09/2014.
 */
@Service
public class VolumeService {

    @Autowired
    private VolumeRepository volumeRepository;

    public Volume marcarComoImprimido(Long id, ComandoAlterarData comandoAlterarData) {
        Volume volume = volumeRepository.findOne(id);
        volume.setDataImpressao(comandoAlterarData.getData());
        volume.setStatus(VolumeStatus.IMPRESSO);
        return volumeRepository.save(volume);
    }

    public Volume marcarComoRevisado(Long id, ComandoMarcarRevisado comandoMarcarRevisado) {
        Volume volume = volumeRepository.findOne(id);
        volume.setDataRevisao(comandoMarcarRevisado.getDataRevisao());
        volume.setResponsavelRevisao(Usuario.of(comandoMarcarRevisado.getRevisor()));
        volume.setStatus(VolumeStatus.REVISADO);
        return volumeRepository.save(volume);
    }

    public Volume marcarComoEnviado(Long id, ComandoAlterarData comandoAlterarData) {
        Volume volume = volumeRepository.findOne(id);
        volume.setStatus(VolumeStatus.ENVIADO);
        volume.setDataEnviado(comandoAlterarData.getData());
        return volumeRepository.save(volume);
    }

    public Volume rejeitar(Long id) {
        Volume volume = volumeRepository.findOne(id);
        volume.rejeitar();
        return volumeRepository.save(volume);
    }

    public Volume reativar(Long id) {
        Volume volume = volumeRepository.findOne(id);
        volume.setStatus(VolumeStatus.ANDAMENTO);
        return volumeRepository.save(volume);
    }

    public Volume criarVolume(ComandoSalvarVolume comandoSalvarVolume) {
        Volume volume = montarVolume(comandoSalvarVolume);
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

    public Volume atualizarVolume( Long id, ComandoSalvarVolume comandoSalvarVolume) {
        Volume volume = montarVolume(comandoSalvarVolume);
        volume.setId(id);
        return volumeRepository.save(volume);
    }


    public Volume buscar(Long idVolume) {
        return volumeRepository.findOne(idVolume);
    }
}
