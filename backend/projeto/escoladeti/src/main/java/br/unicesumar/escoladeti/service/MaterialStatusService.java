package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.repository.MaterialStatusRepository;
import br.unicesumar.escoladeti.view.ViewMaterialProduzido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MaterialStatusService {

    @Autowired
    private MaterialStatusRepository  materialStatusRepository;

    public List<ViewMaterialProduzido> listarMateriaisProduzidos() {
        return this.materialStatusRepository.findByStatusContainingOrderByNomeAsc("FINALIZADO");
    }

}
