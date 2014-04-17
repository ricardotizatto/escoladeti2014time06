package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.entity.Observacao;

public interface ObservacaoRepository extends JpaRepository<Observacao, Long>{

    Observacao findByObservacao(String observacao);
}
