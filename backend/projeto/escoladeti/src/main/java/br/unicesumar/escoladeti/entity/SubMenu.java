package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;

@Entity
public class SubMenu extends Entidade{

    private String nome;
    private Menu menu;
    
    public SubMenu() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
}
