package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.Participante;
import br.unicesumar.escoladeti.entity.ParticipantePeriodo;
import br.unicesumar.escoladeti.repository.ParticipantePeriodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantePeriodoService {

    @Autowired
    private ParticipantePeriodoRepository participantePeriodoRepository;
    
    public List<ParticipantePeriodo> listarParticipantesPorPeriodo(Long periodoid){
        return participantePeriodoRepository.findByPeriodo_id(periodoid);
    }

    public List<ParticipantePeriodo> getTodos() {
        return participantePeriodoRepository.findAll();
    }

    public ParticipantePeriodo salvar(ParticipantePeriodo participantePeriodo) {
        return participantePeriodoRepository.save(participantePeriodo);
    }


    
}
