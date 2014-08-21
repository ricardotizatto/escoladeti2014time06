package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.CepUnico;
import br.unicesumar.escoladeti.repository.CepUnicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepUnicoService {
    @Autowired
    private CepUnicoRepository cepUnicoRepository;
    
    public CepUnico findByCepContainingOrderByCepAsc(String cep) {
        return this.cepUnicoRepository.findByCepOrderByCepAsc(cep);
    }

    public List<CepUnico> getTodos() {
        return cepUnicoRepository.findAll();
    }
}
