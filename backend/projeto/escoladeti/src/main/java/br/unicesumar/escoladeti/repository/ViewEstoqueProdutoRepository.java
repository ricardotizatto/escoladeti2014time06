package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.view.ViewEstoqueProduto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewEstoqueProdutoRepository extends JpaRepository<ViewEstoqueProduto, Long>{
    
    @Override
    public List<ViewEstoqueProduto> findAll();
}
