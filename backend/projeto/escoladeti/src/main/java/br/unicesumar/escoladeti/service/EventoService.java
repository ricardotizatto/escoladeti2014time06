package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Evento;
import br.unicesumar.escoladeti.entity.Pais;
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

//    public List<Evento> getTodos() {
//        return eventoRepository.findAll();
//    }
     public List<Evento> listarTodosEventos() {
	return eventoRepository.findAll();
    }
    public void deletar(Evento evento) {
        eventoRepository.delete(evento);
    }

    public Evento getById(Long id) {
        return eventoRepository.findById(id);
    }

    public DataPage<Evento> getTodos(Integer pagina) {
        return new DataPage<>(eventoRepository.findAll(pageRequestForAsc(pagina, "titulo")));
    }

    public DataPage<Evento> getByName(String titulo) {
        return new DataPage<Evento>(eventoRepository.findByTituloContainingOrderByTituloAsc(titulo, pageRequestForAsc(1, "titulo")));
    }
}
