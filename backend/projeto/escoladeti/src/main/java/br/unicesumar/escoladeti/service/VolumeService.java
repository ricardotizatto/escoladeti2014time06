package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoSalvarVolume;
import br.unicesumar.escoladeti.entity.*;
import br.unicesumar.escoladeti.enums.SolicitacaoVolumeStatus;
import br.unicesumar.escoladeti.enums.Transcricao;
import br.unicesumar.escoladeti.enums.VolumeStatus;
import br.unicesumar.escoladeti.repository.LivroRepository;
import br.unicesumar.escoladeti.repository.SolicitacaoItemRepository;
import br.unicesumar.escoladeti.repository.SolicitacaoVolumeRepository;
import br.unicesumar.escoladeti.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Jhonatan on 16/09/2014.
 */
@Service
public class VolumeService {

    @Autowired
    private VolumeRepository volumeRepository;

    @Autowired
    private LivroRepository  livroRepository;

    @Autowired
    private SolicitacaoVolumeRepository solicitacaoVolumeRepository;

    public void deletar(Long id) {
        Volume volume = volumeRepository.findOne(id);

        List<SolicitacaoVolume> solicitacaoVolumes = solicitacaoVolumeRepository.findByVolumeId(volume.getId());

        if (solicitacaoVolumes.size() > 0) {
            throw new RuntimeException("Este volume esta vinculado a uma ordem de produção e não pode ser excluido");
        }

        volumeRepository.delete(id);
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
    public Volume reativar(Long id) {
        Volume volume = volumeRepository.findOne(id);
        volume.reativar();
        return volumeRepository.save(volume);
    }

    @Transactional
    public Volume criarVolume( ComandoSalvarVolume comandoSalvarVolume) {
        Volume volume = montarVolume(comandoSalvarVolume);

        if (volume.getPaginaFim() <= volume.getPaginaInicio()) {
            throw new RuntimeException("Pagina final deve ser maior que paginá inicial");
        }

        if (volume.getPaginaInicio() < 0 ) {
            throw new RuntimeException("Página inicial deve ser maior que 0");
        }


        Livro livro = livroRepository.findById(comandoSalvarVolume.getIdLivro());
        Transcricao transcricao = Transcricao.of(comandoSalvarVolume.getTranscricao());

        livro.validarPaginas(comandoSalvarVolume.getPaginaInicio(),
                comandoSalvarVolume.getPaginaFim(), transcricao);

        volume.setTranscricao(transcricao);
        volume.setStatus(VolumeStatus.ANDAMENTO);
        volume.setIdLivro(comandoSalvarVolume.getIdLivro());
        volume.setOutro(comandoSalvarVolume.getOutro());
        volumeRepository.save(volume);

        return volume;
    }

    private Volume montarVolume(ComandoSalvarVolume comandoSalvarVolume) {
        Volume volume = new Volume();
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
        volume.setDataAlteracao(volumeSalvo.getDataAlteracao());
        volume.setIdLivro(volumeSalvo.getIdLivro());
        volume.setCaminhoAnexo(volumeSalvo.getCaminhoAnexo());
        volume.setTranscricao(volumeSalvo.getTranscricao());
        return volumeRepository.save(volume);
    }


    public Volume buscar(Long idVolume) {
        return volumeRepository.findOne(idVolume);
    }
}
