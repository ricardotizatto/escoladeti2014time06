package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.SubMenu;
import br.unicesumar.escoladeti.repository.SubMenuRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubMenuService {

    @Autowired
    private SubMenuRepository subMenuRepository;

    public SubMenu salvar(SubMenu subMenu) {
        return subMenuRepository.save(subMenu);
    }

    public List<SubMenu> getTodos() {
        return subMenuRepository.findAll();
    }

    public List<SubMenu> getTodosPorMenu(Long id) {
        return subMenuRepository.findByMenuContainingOrderByNomeAsc(id);
    }

    public void deletar(SubMenu subMenu) {
        subMenuRepository.delete(subMenu);
    }

    public SubMenu getById(Long id) {
        return subMenuRepository.findById(id);
    }
}
