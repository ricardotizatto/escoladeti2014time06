package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.Evento;
import br.unicesumar.escoladeti.entity.Participante;
import br.unicesumar.escoladeti.entity.ParticipantePeriodo;
import br.unicesumar.escoladeti.entity.Periodo;
import br.unicesumar.escoladeti.repository.EventoRepository;
import br.unicesumar.escoladeti.repository.ParticipantePeriodoRepository;
import br.unicesumar.escoladeti.repository.ParticipanteRepository;
import br.unicesumar.escoladeti.repository.PeriodoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;
    
    @Autowired
    private ParticipantePeriodoRepository participantePeriodoRepository;
    
    @Autowired
    private PeriodoRepository periodoRepository;
    
    @Autowired
    private EventoRepository eventoRepository;

    public Participante salvar(Participante participante) {
         
        Participante  p = participanteRepository.save(participante);
        System.out.println("Entrou no cadastro participante");
        Evento  ev  = eventoRepository.findById(participante.getIdevento());
        if (ev.getDisponivel() > 0){
          ev.setDisponivel(ev.getDisponivel() - 1);
          eventoRepository.save(ev);
        }
        List<ParticipantePeriodo> countRegistros = new ArrayList<ParticipantePeriodo>();
        for(Periodo period : periodoRepository.findByEvento(eventoRepository.findById(participante.getIdevento()))){
            if(participantePeriodoRepository.findByPeriodo_id(period.getId()).size() > 0){
                  countRegistros = participantePeriodoRepository.findByPeriodo_id(period.getId());
            }      
        }
        boolean condicaoAlteraOuNao = true;
        for(ParticipantePeriodo pp:countRegistros ){
           if(pp.getParticipante().equals(participante)) {
             condicaoAlteraOuNao= false;  
           }
        }
        
        if(ev.getDisponivel() == 0){
            condicaoAlteraOuNao= false;
            throw new RuntimeException("Não possui vaga disponível para este evento");
        }
        
        System.out.println("No count dos registros: " + countRegistros.size());
        if(condicaoAlteraOuNao){
            for(Periodo period : periodoRepository.findByEvento(eventoRepository.findById(participante.getIdevento()))){
                ParticipantePeriodo pp = new ParticipantePeriodo();
                pp.setParticipante(participante);
                pp.setPeriodo(period);
                pp.setPresente(false);
                participantePeriodoRepository.save(pp);
            }
        }
        System.out.println("Finalizou  cadastro participante");
        return p;
    }

    public List<Participante> getTodos() {
        return participanteRepository.findAll();
    }

    public void deletar(Participante participante) {
        participanteRepository.delete(participante);
    }

    public Participante getById(Long id) {
        return participanteRepository.findById(id);
    }

    public List<Participante> getByName(String nome) {
        return this.participanteRepository.findByNomeContainingOrderByNomeAsc(nome);
    }
    
    public List<Participante> getByIdevento(Long idevento) {
        return this.participanteRepository.findByIdevento(idevento);
    }
}
