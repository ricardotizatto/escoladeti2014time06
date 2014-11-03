package br.unicesumar.escoladeti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.Caracteristica;
import br.unicesumar.escoladeti.enums.Tipo;
import java.util.List;

public interface CaracteristicaRepository extends JpaRepository<Caracteristica, Long>{

  public List<Caracteristica> findByTipoOrderByDescricaoAsc(Tipo tipo);

}
