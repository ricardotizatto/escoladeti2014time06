package enderecamento;

class FaixaCep {
    private String inicioCEP;
    private String fimCEP;
    private Bairro bairro;
    private Logradouro logradouro;

    public String getInicioCEP() {
        return inicioCEP;
    }

    public void setInicioCEP(String inicioCEP) {
        this.inicioCEP = inicioCEP;
    }

    public String getFimCEP() {
        return fimCEP;
    }

    public void setFimCEP(String fimCEP) {
        this.fimCEP = fimCEP;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }
}
