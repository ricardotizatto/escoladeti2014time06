package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.SubMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubMenuRepository extends JpaRepository<SubMenu, Long>{
    public SubMenu findById(Long id);
}
