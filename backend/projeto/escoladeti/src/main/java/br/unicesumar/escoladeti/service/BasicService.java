package br.unicesumar.escoladeti.service;

import java.util.List;

import br.unicesumar.escoladeti.controller.DataPage;

public interface BasicService<T> {
	T salvar(T entidade);
	void deletar(T entidade);
	DataPage<T> paginar(Integer pagina);
	List<T> listar();
	T buscar(Long id);
}
