package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.Evento;
import br.unicesumar.escoladeti.repository.EventoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Evento salvar(Evento evento) {
        return eventoRepository.save(evento);
    }

    public List<Evento> getTodos() {
        return eventoRepository.findAll();
    }

    public void deletar(Evento evento) {
        eventoRepository.delete(evento);
    }

    public Evento getById(Long id) {
        return eventoRepository.findById(id);
    }

    public List<Evento> getByName(String titulo) {
        return this.eventoRepository.findByTituloContainingOrderByTituloAsc(titulo);
    }
    
}
