/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoSalvarPerfil;
import br.unicesumar.escoladeti.entity.PerfilAcesso;
import br.unicesumar.escoladeti.entity.PerfilItemAcesso;
import br.unicesumar.escoladeti.repository.PerfilAcessoRepository;
import java.util.List;

import br.unicesumar.escoladeti.repository.PerfilItemAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Walber
 */
@Service
public class PerfilAcessoService {

    @Autowired
    private PerfilAcessoRepository perfilAcessoRepository;

    @Autowired
    private PerfilItemAcessoRepository perfilItemAcessoRepository;

    @Transactional
    public PerfilAcesso salvar(ComandoSalvarPerfil perfil) {
        PerfilAcesso perfilAcesso ;

        if (perfil.getItens().size() <= 0) {
            throw new RuntimeException("Perfil deve possuir ao menos um privilégio");
        }

        if (perfil.getId() != null) {
            perfilAcesso = perfilAcessoRepository.findOne(perfil.getId());

            for (PerfilItemAcesso perfilItemAcesso : perfilAcesso.getItens()) {
                perfilItemAcessoRepository.delete(perfilItemAcesso);
            }

            perfilAcesso.getItens().clear();

        } else {
            perfilAcesso = new PerfilAcesso();
        }

        perfilAcesso.setNome(perfil.getNome());
        perfilAcesso.setId(perfil.getId());

        for (Long idItem: perfil.getItens()) {
            perfilAcesso.adcionarItem(idItem);
        }

        perfilAcesso = perfilAcessoRepository.save(perfilAcesso);
        return  perfilAcesso;
    }

    public void deletar(PerfilAcesso perfil) {
        this.perfilAcessoRepository.delete(perfil);
    }

    public PerfilAcesso getById(Long id) {
        return this.perfilAcessoRepository.findById(id);
    }

    public List<PerfilAcesso> getTodos() {
        return this.perfilAcessoRepository.findAll();
    }

}
