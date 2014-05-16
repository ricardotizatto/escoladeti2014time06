/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.PerfilAcesso;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Walber
 */

public interface PerfilAcessoRepository extends JpaRepository<PerfilAcesso, Long>{
    
    public PerfilAcesso findById(Long id);
    
}
