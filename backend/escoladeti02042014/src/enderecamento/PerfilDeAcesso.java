package enderecamento;

import java.util.List;

class PerfilDeAcesso {
    private String nome;
    private List<ItemDeAcesso> itensDeAcesso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ItemDeAcesso> getItensDeAcesso() {
        return itensDeAcesso;
    }

    public void setItensDeAcesso(List<ItemDeAcesso> itensDeAcesso) {
        this.itensDeAcesso = itensDeAcesso;
    }
}
