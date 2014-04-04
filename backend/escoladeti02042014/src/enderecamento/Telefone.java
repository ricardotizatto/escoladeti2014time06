package enderecamento;

class Telefone {
    private int ddd;
    private long telefone;
    private String tipo;
    private long ramal;

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getRamal() {
        return ramal;
    }

    public void setRamal(long ramal) {
        this.ramal = ramal;
    }
}
