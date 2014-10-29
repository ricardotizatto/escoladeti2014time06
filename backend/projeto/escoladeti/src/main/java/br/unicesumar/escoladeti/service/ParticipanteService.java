package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.Participante;
import br.unicesumar.escoladeti.entity.ParticipantePeriodo;
import br.unicesumar.escoladeti.entity.Periodo;
import br.unicesumar.escoladeti.repository.EventoRepository;
import br.unicesumar.escoladeti.repository.ParticipantePeriodoRepository;
import br.unicesumar.escoladeti.repository.ParticipanteRepository;
import br.unicesumar.escoladeti.repository.PeriodoRepository;
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
        
        for(Periodo period : periodoRepository.findByEvento(eventoRepository.findById(participante.getIdevento()))){
            ParticipantePeriodo pp = new ParticipantePeriodo();
            pp.setParticipante(participante);
            pp.setPeriodo(period);
            pp.setPresente(false);
            participantePeriodoRepository.save(pp);
        }
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
