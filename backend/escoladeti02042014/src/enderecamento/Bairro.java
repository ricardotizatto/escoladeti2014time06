package enderecamento;

class Bairro {
    private String nome;
    private Cidade cidade;
    private FaixaCep faixaCep;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public FaixaCep getFaixaCep() {
        return faixaCep;
    }

    public void setFaixaCep(FaixaCep faixaCep) {
        this.faixaCep = faixaCep;
    }
}
