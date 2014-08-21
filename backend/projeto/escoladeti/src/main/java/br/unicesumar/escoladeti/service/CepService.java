package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.BuscaCep;
import br.unicesumar.escoladeti.entity.Cep;
import br.unicesumar.escoladeti.entity.CepUnico;
import br.unicesumar.escoladeti.repository.CepRepository;
import br.unicesumar.escoladeti.repository.CepUnicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    @Autowired
    private CepRepository cepRepository;
    @Autowired
    private CepUnicoRepository cepUnicoRepository;

    public BuscaCep findByCepContainingOrderByCepAsc(String cep) {

        try {
            BuscaCep retornoCep = this.cepRepository.findByCepOrderByCepAsc(cep);
            

            if (retornoCep.getId() > 0) {
                return retornoCep;
            }

        } catch (Exception e) {
            try {
                CepUnico retornoCepUnico = this.cepUnicoRepository.findByCepOrderByCepAsc(cep);

                if (retornoCepUnico.getId() > 0) {
                    Cep CepAux = new Cep();
                    CepAux.setCidade(retornoCepUnico.getCidade());
                    CepAux.setUf(retornoCepUnico.getUf());
                    CepAux.setCep(retornoCepUnico.getCep());
                    //return CepAux;
                    return null;
                }

            } catch (Exception f) {
                return new BuscaCep();
            }

        }
        return new BuscaCep();
    }
}
