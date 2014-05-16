/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.PerfilAcesso;
import br.unicesumar.escoladeti.repository.PerfilAcessoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Walber
 */
@Service
public class PerfilAcessoService {

    @Autowired
    private PerfilAcessoRepository perfilAcesso;

    public PerfilAcesso salvar(PerfilAcesso perfil) {
        return this.perfilAcesso.save(perfil);
    }

    public void deletar(PerfilAcesso perfil) {
        this.perfilAcesso.delete(perfil);
    }

    public PerfilAcesso getById(Long id) {
        return this.perfilAcesso.findById(id);
    }

    public List<PerfilAcesso> getTodos() {
        return this.perfilAcesso.findAll();
    }

}
