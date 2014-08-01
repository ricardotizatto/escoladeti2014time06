package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.Cep;
import br.unicesumar.escoladeti.repository.CepRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {
    @Autowired
    private CepRepository cepRepository;
    
    public Cep findByCepContainingOrderByCepAsc(String cep) {
        return this.cepRepository.findByCepContainingOrderByCepAsc(cep);
    }

    public List<Cep> getTodos() {
        return cepRepository.findAll();
    }
}
