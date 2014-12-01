package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoAlterarData;
import br.unicesumar.escoladeti.comando.ComandoSalvarSolicitacaoVolume;
import br.unicesumar.escoladeti.comando.ComandoSalvarVolume;
import br.unicesumar.escoladeti.entity.SolicitacaoVolume;
import br.unicesumar.escoladeti.entity.Volume;
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
    public SolicitacaoVolume criar(Long idSolicitacaoItem, ComandoSalvarSolicitacaoVolume comando) {
        SolicitacaoVolume solicitacaoVolume = new SolicitacaoVolume();
        solicitacaoVolume.setIdVolume(comando.getVolume());
        solicitacaoVolume.setIdResponsavel(comando.getResponsavel());
        solicitacaoVolume.setIdSolicitacaoItem(idSolicitacaoItem);
        solicitacaoVolume.setObservacao(comando.getObservacao());
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
    public void marcarComoEnviado(Long id, List<ComandoAlterarData> comandos) {

        for(ComandoAlterarData comandoAlterarData : comandos) {
            SolicitacaoVolume solicitacaoVolume = getById(id);
            solicitacaoVolume.marcarComoEnviado(comandoAlterarData);
            solicitacaoVolumeRepository.save(solicitacaoVolume);
        }

    }

    @Transactional
    public void reativar(Long id, List<ComandoAlterarData> comandos) {

        for(ComandoAlterarData comandoAlterarData : comandos) {
            SolicitacaoVolume solicitacaoVolume = getById(id);
            solicitacaoVolume.retivar();
            solicitacaoVolumeRepository.save(solicitacaoVolume);
        }

    }

    @Transactional
    public void rejeitar(Long id, List<ComandoAlterarData> comandos) {

        for(ComandoAlterarData comandoAlterarData : comandos) {
            SolicitacaoVolume solicitacaoVolume = getById(id);
            solicitacaoVolume.rejeitar(comandoAlterarData);
            solicitacaoVolumeRepository.save(solicitacaoVolume);
        }
    }

    @Transactional
    public void marcarComoImpresso(Long id,  List<ComandoAlterarData> comandos) {


        for(ComandoAlterarData comandoAlterarData : comandos) {
            SolicitacaoVolume solicitacaoVolume = getById(id);
            solicitacaoVolume.marcarComoImpresso(comandoAlterarData);
            solicitacaoVolumeRepository.save(solicitacaoVolume);
        }

    }

    @Transactional
    public void marcarComoRevisado(Long id,  List<ComandoAlterarData> comandos) {

        for(ComandoAlterarData comandoAlterarData : comandos) {
            SolicitacaoVolume solicitacaoVolume = getById(id);
            solicitacaoVolume.marcarComoRevisado(comandoAlterarData);
            solicitacaoVolumeRepository.save(solicitacaoVolume);
        }

    }
}
