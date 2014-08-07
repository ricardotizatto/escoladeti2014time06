package br.unicesumar.escoladeti.service;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.Solicitacao;
import br.unicesumar.escoladeti.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService implements BasicService<Solicitacao> {
	
	@Autowired
	private SolicitacaoRepository solicitacaoRepository;
	
	@Override
	public void deletar(Solicitacao entidade) {
		solicitacaoRepository.delete(entidade);		
	}

	@Override
	public DataPage<Solicitacao> paginar(Integer pagina) {
		return new DataPage<>(solicitacaoRepository.findAll(pageRequestForAsc(pagina, "id")));
	}

	@Override
	public Solicitacao buscar(Long id) {
		return solicitacaoRepository.findOne(id);
	}

	@Override
	public Solicitacao salvar(Solicitacao entidade) {
		return solicitacaoRepository.save(entidade);
	}

	@Override
	public List<Solicitacao> listar() {
		return solicitacaoRepository.findAll();
	}
	
	
}
