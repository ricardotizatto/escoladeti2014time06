package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoAlterarData;
import br.unicesumar.escoladeti.entity.SolicitacaoVolume;
import br.unicesumar.escoladeti.repository.SolicitacaoVolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jhonatan on 22/10/2014.
 */
@Service
public class SolicitacaoVolumeService {

    @Autowired
    private SolicitacaoVolumeRepository solicitacaoVolumeRepository;

    @Transactional
    public SolicitacaoVolume marcarComoEnviado(Long id, ComandoAlterarData comandoAlterarData) {
        SolicitacaoVolume solicitacaoVolume = solicitacaoVolumeRepository.findOne(id);
        solicitacaoVolume.marcarComoEnviado(comandoAlterarData.getDataAsDate());
        return solicitacaoVolumeRepository.save(solicitacaoVolume);
    }
}
