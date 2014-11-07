package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.repository.PeriodoEventoRepository;
import br.unicesumar.escoladeti.view.ViewPeriodoEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PeriodoEventoService {
    
   @Autowired
    private PeriodoEventoRepository periodoeventoRepository;
        
    public DataPage<ViewPeriodoEvento> getProximosEventos(Integer pagina) {
        return new DataPage<>(periodoeventoRepository.findByStatuseventoTrue(new PageRequest( pagina, 4 )));
    }
    
    public DataPage<ViewPeriodoEvento> getUltimosEventos(Integer pagina) {
        return new DataPage<>(periodoeventoRepository.findByStatuseventoFalse(new PageRequest( pagina, 4 )));
    }
}
