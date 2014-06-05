package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.PessoaEndereco;

public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Long> {
    
}
