package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Volume;
import br.unicesumar.escoladeti.enums.Transcricao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Jhonatan on 16/09/2014.
 */
public interface VolumeRepository extends JpaRepository<Volume, Long> {

    List<Volume> findByTranscricaoAndIdLivro(Transcricao transcricao, long idLivro);
    Page<Volume> findByIdAndIdLivroAndTranscricao(Long id, Long idLivro, Transcricao transcricao, Pageable pageable);


    Page<Volume> findByIdLivroAndTranscricao(Long idLivro, Transcricao of, Pageable paginaInicio);
}
