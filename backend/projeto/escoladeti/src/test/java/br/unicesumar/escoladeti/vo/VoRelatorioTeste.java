package br.unicesumar.escoladeti.vo;

import java.io.Serializable;

/**
 *
 * @author Alisson
 */
public class VoRelatorioTeste implements Serializable {

    private String nome;
    private String dataNascimento;
    private String cpf;

    public VoRelatorioTeste() {
    }
    private VoRelatorioTeste(VoRelatorioEventoBuilder builder) {
        this.nome = builder.nome;
        this.dataNascimento = builder.dataNascimento;
        this.cpf = builder.cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public VoRelatorioEventoBuilder createBuilder() {
        return new VoRelatorioEventoBuilder();
    }
    
    public class VoRelatorioEventoBuilder {
        
        private String nome;
        private String dataNascimento;
        private String cpf;
        
        public VoRelatorioEventoBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }
        public VoRelatorioEventoBuilder dataNascimento(String dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }
        public VoRelatorioEventoBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }
        
        public VoRelatorioTeste build() {
            return new VoRelatorioTeste(this);
        }
    }
}
