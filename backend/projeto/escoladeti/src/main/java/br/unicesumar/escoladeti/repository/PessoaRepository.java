package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    public Pessoa findById(Long id);
    public Pessoa findByNome(String nome);
    public Page<Pessoa> findByNomeContainingOrderByNomeAsc(String nome, Pageable pageable);
}
