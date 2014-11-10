package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.repository.VolumeLivroRepository;
import br.unicesumar.escoladeti.view.ViewVolumeLivro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolumeLivroService {

    @Autowired
    private VolumeLivroRepository  volumelivroRepository;

    public DataPage<ViewVolumeLivro> listarLivrosTranscritos(Integer pagina) {
        return new DataPage<>(this.volumelivroRepository.findByStatusContainingOrderByNomeAsc("REVISADO", pageRequestForAsc(pagina, "nome")));
    }
    
    public DataPage<ViewVolumeLivro> buscaLivrosTranscritos(String nomeParcial) {
        return new DataPage<ViewVolumeLivro>
        (volumelivroRepository.findByNomeContainingOrAutorContainingOrEditoraContainingOrDisciplinaContainingOrTranscricaoContainingOrderByNomeAsc
        ( nomeParcial, nomeParcial, nomeParcial, nomeParcial, nomeParcial, pageRequestForAsc(1, "nome")));
    }

}
