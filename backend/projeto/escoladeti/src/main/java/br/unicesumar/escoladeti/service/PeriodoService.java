package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Periodo;
import br.unicesumar.escoladeti.repository.PeriodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import static org.springframework.data.domain.Sort.Direction.ASC;
import org.springframework.stereotype.Service;

@Service
public class PeriodoService {

    @Autowired
    private PeriodoRepository periodoRepository;

    public Periodo salvar(Periodo periodo) {
        return periodoRepository.save(periodo);
    }

     public List<Periodo> listarTodosPeriodos() {
	return periodoRepository.findAll();
    }
    public void deletar(Periodo periodo) {
        periodoRepository.delete(periodo);
    }

    public Periodo getById(Long id) {
        return periodoRepository.findById(id);
    }
    
    public DataPage<Periodo> listarUltimosPeriodos() {
        return new DataPage<>(periodoRepository.findAll(pageRequestForAsc(1, "data")));
    }
    
}
