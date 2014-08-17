package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long>{
    public Menu findById(Long id);
}
