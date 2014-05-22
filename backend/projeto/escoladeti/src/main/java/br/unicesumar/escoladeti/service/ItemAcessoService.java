/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.ItemAcesso;
import br.unicesumar.escoladeti.repository.ItemAcessoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Walber
 */
@Service
public class ItemAcessoService {
    
    @Autowired
    private ItemAcessoRepository itemAcessoRespository;

    public ItemAcesso salvar(ItemAcesso itemAcesso) {
        return this.itemAcessoRespository.save(itemAcesso);
    }

    public List<ItemAcesso> getTodos() {
        return this.itemAcessoRespository.findAll();
    }

    public ItemAcesso getById(Long id) {
        return this.itemAcessoRespository.findById(id);
    }
    public void deletar(ItemAcesso itemAcesso){
        this.itemAcessoRespository.delete(itemAcesso);
    }
}
