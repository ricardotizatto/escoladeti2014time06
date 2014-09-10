package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.Menu;
import br.unicesumar.escoladeti.repository.MenuRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    
    @Autowired
    private MenuRepository menuRepository;
    
    public Menu salvar(Menu menu) {
        return menuRepository.save(menu);
    }

    public List<Menu> getTodos() {
        return menuRepository.findAll();
    }

    public void deletar(Menu menu) {
        menuRepository.delete(menu);
    }

    public Menu getById(Long id) {
        return menuRepository.findById(id);
    }
}
