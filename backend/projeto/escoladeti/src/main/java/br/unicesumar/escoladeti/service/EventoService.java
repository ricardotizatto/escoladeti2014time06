package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoSalvarEvento;
import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Evento;
import br.unicesumar.escoladeti.entity.Periodo;
import br.unicesumar.escoladeti.repository.EventoRepository;
import br.unicesumar.escoladeti.repository.ParticipanteRepository;
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
    private ParticipanteRepository participanteRepository;

    @Autowired
    private PeriodoRepository periodoRepository;

    public Evento salvar(Evento evento) {
        return eventoRepository.save(evento);
    }

    public List<Evento> listarTodosEventos() {
        return eventoRepository.findAll();
    }

    public void deletar(Evento evento) throws Exception{
        if (participanteRepository.findByIdevento(evento.getId()).isEmpty()) {
            eventoRepository.delete(evento);
        }else{
            throw new RuntimeException("Evento " + evento.getTitulo() + " não pode ser deletado, pois possuí participante inscrito");
        }
    }
    
    public Evento getById(Long id) {
        return eventoRepository.findById(id);
    }

    public DataPage<Evento> getTodos(Integer pagina) {
        return new DataPage<>(eventoRepository.findAll(pageRequestForAsc(pagina, "titulo")));
    }
    
    public DataPage<Evento> getTodosAbertos(Integer pagina) {
        return new DataPage<>(eventoRepository.findByStatuseventoTrue(pageRequestForAsc(pagina, "titulo")));
    }
    
     public DataPage<Evento> getTodosFechados(Integer pagina) {
        return new DataPage<>(eventoRepository.findByStatuseventoFalse(pageRequestForAsc(pagina, "titulo")));
    }

    public DataPage<Evento> getEventoPorTitulo(String titulo, String status) {
        if(status.equals("aberto")){
            return new DataPage<Evento>(eventoRepository.findByTituloContainingAndStatuseventoTrueOrderByTituloAsc(titulo, pageRequestForAsc(1, "titulo")));
        }else{
            return new DataPage<Evento>(eventoRepository.findByTituloContainingAndStatuseventoFalseOrderByTituloAsc(titulo, pageRequestForAsc(1, "titulo")));
        }
        
    }

    public DataPage<Evento> getProximosEventos(Integer pagina) {
        return new DataPage<>(eventoRepository.findByStatuseventoTrue(new PageRequest( pagina, 4 )));
    }
    
    public DataPage<Evento> getUltimosEventos(Integer pagina) {
        return new DataPage<>(eventoRepository.findByStatuseventoFalse(new PageRequest( pagina, 4 )));
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
                .limite(comando.getLimite())
                .disponivel(comando.getDisponivel())
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

	public List<Evento> obterEventosParaRelatorio() {
		return null;
	}
}
