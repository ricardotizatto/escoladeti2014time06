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
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Jhonatan on 16/09/2014.
 */
@Service
public class VolumeService {

    @Autowired
    private VolumeRepository volumeRepository;

    public void deletar(Long id) {
        volumeRepository.delete(id);
    }

    @Transactional
    public Volume marcarComoImprimido(Long id, ComandoAlterarData comandoAlterarData) {
        Volume volume = volumeRepository.findOne(id);

        if (!volume.getStatus().equals(VolumeStatus.ANDAMENTO)) {
            throw new RuntimeException("Sómente volume em Andamento pode ser marcado como impresso.");
        }

        if (comandoAlterarData.getData().compareTo(new Date()) > 0) {
            throw new RuntimeException("Data da impressão não pode ser maior que a data atual");
        }

        volume.setDataImpressao(comandoAlterarData.getData());
        volume.setStatus(VolumeStatus.IMPRESSO);
        Volume volumeSalvo = volumeRepository.save(volume);
        return volumeSalvo;
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

    public Volume rejeitar(Long id, ComandoMarcarRevisado comandoMarcarRevisado) {
        Volume volume = volumeRepository.findOne(id);
        volume.setDataRevisao(comandoMarcarRevisado.getDataRevisao());
        volume.setResponsavelRevisao(Usuario.of(comandoMarcarRevisado.getRevisor()));
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
