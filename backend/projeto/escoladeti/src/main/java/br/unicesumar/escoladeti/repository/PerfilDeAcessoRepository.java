package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.PerfilAcesso;

public interface PerfilDeAcessoRepository extends JpaRepository<PerfilAcesso, Long> {
    public PerfilAcesso findById();
    public List<PerfilAcesso> findByNomeContainingOrderByNomeAsc(String nome);
}
