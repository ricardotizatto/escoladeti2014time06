package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoAlterarData;
import br.unicesumar.escoladeti.comando.ComandoSalvarSolicitacaoVolume;
import br.unicesumar.escoladeti.comando.ComandoSalvarVolume;
import br.unicesumar.escoladeti.entity.SolicitacaoVolume;
import br.unicesumar.escoladeti.entity.Volume;
import br.unicesumar.escoladeti.enums.SolicitacaoVolumeStatus;
import br.unicesumar.escoladeti.repository.SolicitacaoVolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jhonatan on 22/10/2014.
 */
@Service
public class SolicitacaoVolumeService {

    @Autowired
    private SolicitacaoVolumeRepository solicitacaoVolumeRepository;

    @Transactional
    public SolicitacaoVolume criar( ComandoSalvarSolicitacaoVolume comando) {
        SolicitacaoVolume solicitacaoVolume = new SolicitacaoVolume();
        solicitacaoVolume.setIdVolume(comando.getVolume());
        solicitacaoVolume.setIdResponsavel(comando.getResponsavel());
        solicitacaoVolume.setIdSolicitacaoItem(comando.getIdSolicitacaoItem());
        solicitacaoVolume.setObservacao(comando.getObservacao());
        solicitacaoVolume.setStatus(SolicitacaoVolumeStatus.ANDAMENTO);
        return solicitacaoVolumeRepository.save(solicitacaoVolume);
    }

    @Transactional
    public void deletar(Long id) {
        SolicitacaoVolume solicitacaoVolume = getById(id);

        if (solicitacaoVolume.estaEnviado()) {
            throw new RuntimeException("Volume produzido já enviado, e não pode ser excluido.");
        }

        solicitacaoVolumeRepository.delete(solicitacaoVolume);
    }

    private SolicitacaoVolume getById(Long id) {
        return  solicitacaoVolumeRepository.findOne(id);
    }

    @Transactional
    public void marcarComoEnviado(List<ComandoAlterarData> comandos) {

        for(ComandoAlterarData comandoAlterarData : comandos) {
            SolicitacaoVolume solicitacaoVolume = getById(comandoAlterarData.getId());
            solicitacaoVolume.marcarComoEnviado(comandoAlterarData);
            solicitacaoVolumeRepository.save(solicitacaoVolume);
        }

    }

    @Transactional
    public void reativar(List<ComandoAlterarData> comandos) {

        for(ComandoAlterarData comandoAlterarData : comandos) {
            SolicitacaoVolume solicitacaoVolume = getById(comandoAlterarData.getId());
            solicitacaoVolume.retivar();
            solicitacaoVolumeRepository.save(solicitacaoVolume);
        }

    }

    @Transactional
    public void rejeitar( List<ComandoAlterarData> comandos) {

        for(ComandoAlterarData comandoAlterarData : comandos) {
            SolicitacaoVolume solicitacaoVolume = getById(comandoAlterarData.getId());
            solicitacaoVolume.rejeitar(comandoAlterarData);
            solicitacaoVolumeRepository.save(solicitacaoVolume);
        }
    }

    @Transactional
    public void marcarComoImpresso( List<ComandoAlterarData> comandos) {


        for(ComandoAlterarData comandoAlterarData : comandos) {
            SolicitacaoVolume solicitacaoVolume = getById(comandoAlterarData.getId());
            solicitacaoVolume.marcarComoImpresso(comandoAlterarData);
            solicitacaoVolumeRepository.save(solicitacaoVolume);
        }

    }

    @Transactional
    public void marcarComoRevisado(List<ComandoAlterarData> comandos) {

        for(ComandoAlterarData comandoAlterarData : comandos) {
            SolicitacaoVolume solicitacaoVolume = getById(comandoAlterarData.getId());
            solicitacaoVolume.marcarComoRevisado(comandoAlterarData);
            solicitacaoVolumeRepository.save(solicitacaoVolume);
        }

    }

    public SolicitacaoVolume buscar(Long id) {
        return solicitacaoVolumeRepository.findOne(id);
    }

    public SolicitacaoVolume atualizar(Long id, ComandoSalvarSolicitacaoVolume comandoSalvarSolicitacaoVolume) {
        SolicitacaoVolume solicitacaoVolume = solicitacaoVolumeRepository.findOne(id);
        solicitacaoVolume.setObservacao(comandoSalvarSolicitacaoVolume.getObservacao());

        if (solicitacaoVolume.getStatus().equals(SolicitacaoVolumeStatus.ANDAMENTO)) {
            solicitacaoVolume.setIdVolume(comandoSalvarSolicitacaoVolume.getVolume());
            solicitacaoVolume.setIdResponsavel(comandoSalvarSolicitacaoVolume.getResponsavel());
        }


        return solicitacaoVolumeRepository.save(solicitacaoVolume);
    }
}
