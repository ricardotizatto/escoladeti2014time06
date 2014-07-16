package br.unicesumar.escoladeti.service;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.Cidade;
import br.unicesumar.escoladeti.repository.CidadeRepository;

@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    public Cidade salvar(Cidade cidade){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String data = sdf.format(cidade.getFundacao());
        Date hoje = new Date();
        String atual = sdf.format(hoje);
        
        if(Integer.parseInt(data) > Integer.parseInt(atual) )
            throw new RuntimeException("Data fundação maior que hoje.");
        return this.cidadeRepository.save(cidade);
    }
    public DataPage<Cidade> getTodos(Integer pagina){
        return new DataPage<>(cidadeRepository.findAll(pageRequestForAsc(pagina, "nome")));
    }
    public DataPage<Cidade> getCidadePorNome(String nomeParcial){
        return new DataPage<Cidade>(cidadeRepository.findByNomeContainingOrderByNomeAsc(nomeParcial, pageRequestForAsc(1, "nome")));
    }
    public void deletar(Cidade cidade){
        
        this.cidadeRepository.delete(cidade);
    }
    
    public Cidade getById(Long id){
        return this.cidadeRepository.findOne(id);
    }
	public List<Cidade> listarTodos() {
		return this.cidadeRepository.findAll();
		
	}
	public List<Cidade> listarPorEstado(Long estadoId) {
		return this.cidadeRepository.findByUnidadeFederativaId(estadoId);
	}
    
   /* public Cidade buscarCidadePorNomeFundacaoUnidadeFederativa(Cidade cidade) {
        return this.cidadeRepository.findByNomeAndFundacaoAndUnidadeFederativa(
                cidade.getNome(), cidade.getFundacao(), cidade.getUnidadeFederativa());
    }*/
}
