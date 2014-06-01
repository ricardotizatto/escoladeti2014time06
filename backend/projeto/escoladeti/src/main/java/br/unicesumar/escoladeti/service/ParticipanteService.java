package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.Participante;
import br.unicesumar.escoladeti.repository.ParticipanteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public Participante salvar(Participante participante) {
        return participanteRepository.save(participante);
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
}
