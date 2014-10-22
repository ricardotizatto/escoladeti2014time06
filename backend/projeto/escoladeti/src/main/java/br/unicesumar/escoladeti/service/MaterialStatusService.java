package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.repository.MaterialStatusRepository;
import br.unicesumar.escoladeti.view.ViewMaterialProduzido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MaterialStatusService {

    @Autowired
    private MaterialStatusRepository  materialStatusRepository;

    public DataPage<ViewMaterialProduzido> listarMateriaisProduzidos() {
        return new DataPage<>(this.materialStatusRepository.findByStatusContainingOrderByNomeAsc("FINALIZADO", pageRequestForAsc(1, "nome")));
    }
    
    public DataPage<ViewMaterialProduzido> buscaMateriaisProduzidos(String nomeParcial) {
        return new DataPage<ViewMaterialProduzido>
        (materialStatusRepository.findByNomeContainingOrAutorContainingOrEditoraContainingOrDisciplinaContainingOrTranscricaoContainingOrderByNomeAsc
        ( nomeParcial, nomeParcial, nomeParcial, nomeParcial, nomeParcial, pageRequestForAsc(1, "nome")));
    }

}
