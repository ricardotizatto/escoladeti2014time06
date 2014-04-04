package enderecamento;

class Logradouro {
    private String tipoDoEndereco;
    private String nome;
    private FaixaCep faixaCEP;

    public String getTipoDoEndereco() {
        return tipoDoEndereco;
    }

    public void setTipoDoEndereco(String tipoDoEndereco) {
        this.tipoDoEndereco = tipoDoEndereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public FaixaCep getFaixaCEP() {
        return faixaCEP;
    }

    public void setFaixaCEP(FaixaCep faixaCEP) {
        this.faixaCEP = faixaCEP;
    }
}
