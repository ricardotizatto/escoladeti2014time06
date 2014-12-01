package br.unicesumar.escoladeti.comando;

/**
 * Created by Jhonatan on 29/11/2014.
 */
public class ComandoSalvarSolicitacaoVolume {
    private String observacao;
    private Long volume;
    private Long responsavel;

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Long getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Long responsavel) {
        this.responsavel = responsavel;
    }
}
