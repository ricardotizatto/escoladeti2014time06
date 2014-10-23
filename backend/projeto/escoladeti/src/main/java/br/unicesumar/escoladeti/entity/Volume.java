package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.comando.ComandoSalvarVolume;
import br.unicesumar.escoladeti.enums.VolumeStatus;
import br.unicesumar.escoladeti.util.string.StringUtils;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

@Entity
public class Volume  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private Usuario responsavel;

    @Column(name = "pagina_inicio")
    private Integer paginaInicio;

    @Column(name = "pagina_fim")
    private Integer paginaFim;

    @Enumerated(EnumType.STRING)
    private VolumeStatus status;

    @Column(name = "caminho_anexo")
    private String caminhoAnexo;

    @ManyToOne
    @JoinColumn(name = "id_responsavelrevisao")
    private Usuario responsavelRevisao;

    private String observacao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_impressao")
    private Date dataImpressao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_revisao")
    private Date dataRevisao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_enviado")
    private Date dataEnviado;

    @Column(name = "id_livro")
    private Long idLivro;

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public Integer getPaginaInicio() {
        return paginaInicio;
    }

    public void setPaginaInicio(Integer paginaInicio) {
        this.paginaInicio = paginaInicio;
    }

    public Integer getPaginaFim() {
        return paginaFim;
    }

    public void setPaginaFim(Integer paginaFim) {
        this.paginaFim = paginaFim;
    }

    public VolumeStatus getStatus() {
        return status;
    }

    public void setStatus(VolumeStatus status) {
        this.status = status;
    }

    public Usuario getResponsavelRevisao() {
        return responsavelRevisao;
    }

    public void setResponsavelRevisao(Usuario responsavelRevisao) {
        this.responsavelRevisao = responsavelRevisao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataImpressao() {
        return dataImpressao;
    }

    public void setDataImpressao(Date dataImpressao) {
        this.dataImpressao = dataImpressao;
    }

    public Date getDataRevisao() {
        return dataRevisao;
    }

    public void setDataRevisao(Date dataRevisao) {
        this.dataRevisao = dataRevisao;
    }

    public Date getDataEnviado() {
        return dataEnviado;
    }

    public void setDataEnviado(Date dataEnviado) {
        this.dataEnviado = dataEnviado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaminhoAnexo() {
        return caminhoAnexo;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeArquivo() {
        if (StringUtils.isNotEmpty(caminhoAnexo))
            return new File(getCaminhoAnexo()).getName();

        return "";
    }

    public void setCaminhoAnexo(String caminhoAnexo) {
        this.caminhoAnexo = caminhoAnexo;
    }

    public void rejeitar(Date data, Long revisor, String observacao) {
        if (data == null) {
            throw  new RuntimeException("Data da rejeição deve ser informada.");
        }

        if (revisor == null) {
            throw  new RuntimeException("Revisor deve ser informado.");
        }

        if (data.before(this.dataImpressao)) {
            throw  new RuntimeException("Data de rejeição deve ser maior ou igual a data de impressão.");
        }

        if (data.after(new Date())) {
            throw  new RuntimeException("Data da rejeição deve ser menor ou igual a hoje.");
        }

        if (!this.getStatus().equals(VolumeStatus.IMPRESSO)) {
            throw new RuntimeException("Sómente volume impresso pode ser marcado como rejeitado.");
        }
        setStatus(VolumeStatus.REJEITADO);
        setResponsavelRevisao(Usuario.of(revisor));
        setObservacao(observacao);
        setDataRevisao(data);
    }

    public void reativar() {

        if (this.getStatus().equals(VolumeStatus.CANCELADO)
                || this.getStatus().equals(VolumeStatus.REVISADO)) {
            throw new RuntimeException("Sómente volume rejeitado, ou impresso podem ser reativados.");
        }

        this.setStatus(VolumeStatus.ANDAMENTO);
        this.dataImpressao = null;
        this.dataRevisao = null;
        this.responsavelRevisao = null;
    }

    public void marcarComoRevisado(Date data, Long revisor, String observacao) {
        if (revisor == null) {
            throw new RuntimeException("Informe um revisor.");
        }

        if (data == null) {
            throw new RuntimeException("Informe data da revisão");
        }

        if (!getStatus().equals(VolumeStatus.IMPRESSO)) {
            throw new RuntimeException("Sómente volume impresso pode ser marcado como revisado.");
        }

        if (data.before(this.dataImpressao)) {
            throw  new RuntimeException("Data de revisão deve ser maior ou igual a data de impressão.");
        }

        if (data.after(new Date())) {
            throw new RuntimeException("Data de revisão deve ser menor ou igual a hoje.");
        }

        setDataRevisao(data);
        setResponsavelRevisao(Usuario.of(revisor));
        setObservacao(observacao);
        setStatus(VolumeStatus.REVISADO);
    }

    public void marcarComoImprimido(ComandoSalvarVolume comandoSalvarVolume) {

        if(caminhoAnexo == null) {
            throw new RuntimeException("Arquivo é obrigatório para marcar como impresso");
        }

        if (!getStatus().equals(VolumeStatus.ANDAMENTO)) {
            throw new RuntimeException("Sómente volume em Andamento pode ser marcado como impresso.");
        }

        if (comandoSalvarVolume.getDataAsDate() == null) {
            throw new RuntimeException("Informe data de impressão");
        }

        if (comandoSalvarVolume.getDataAsDate().after(new Date())) {
            throw new RuntimeException("Data da impressão deve ser menor ou igual a data atual.");
        }

        setPaginaInicio(comandoSalvarVolume.getPaginaInicio());
        setPaginaFim(comandoSalvarVolume.getPaginaFim());
        setResponsavel(Usuario.of(comandoSalvarVolume.getResponsavel()));
        setObservacao(comandoSalvarVolume.getObservacao());
        setDataImpressao(comandoSalvarVolume.getDataAsDate());
        setStatus(VolumeStatus.IMPRESSO);
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || ! (o instanceof Volume)){
            return false;
        }

        Volume volume = (Volume) o;

        return volume.getId().equals(this.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
