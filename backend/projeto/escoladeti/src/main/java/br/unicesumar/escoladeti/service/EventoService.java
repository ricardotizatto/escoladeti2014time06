package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoSalvarEvento;
import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Evento;
import br.unicesumar.escoladeti.entity.Periodo;
import br.unicesumar.escoladeti.repository.EventoRepository;
import br.unicesumar.escoladeti.repository.PeriodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;
    
    @Autowired
    private PeriodoRepository periodoRepository;

    public Evento salvar(Evento evento) {
        return eventoRepository.save(evento);
    }

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

    public DataPage<Evento> getProxomosEventos() {
        return new DataPage<>(eventoRepository.findByStatuseventoTrue( new PageRequest(0, 4)));
    }
    
    public DataPage<Evento> getUltimosEventos() {
        return new DataPage<>(eventoRepository.findByStatuseventoFalse(new PageRequest(0, 4)));
    }
    
    public Evento persistirEvento(ComandoSalvarEvento comando, Long id) {
        
        Evento evento = Evento.builder()
                .periodos(comando.getPeriodos())
                .descricao(comando.getDescricao())
                .local(comando.getLocal())
                .participante(null)
                .ministrante(comando.getMinistrante())
                .organizacao(comando.getOrganizacao())
                .statusevento(comando.isStatusevento())
                .tipoEvento(comando.getTipoEvento())
                .titulo(comando.getTitulo())
                .valor(comando.getValor())
                .buildEvento();
        
        if (comando.getId() != null) {
            for (Periodo p : periodoRepository.findByEvento(eventoRepository.findById(id))) {
                periodoRepository.delete(p);
            }
            evento.setId(comando.getId());
        }
        eventoRepository.save(evento);

        return evento;
    }
}
