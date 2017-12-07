package br.ufrn.reuse.remote.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UnidadeDTO {

    @SerializedName("id-unidade")
    @Expose
    private Integer idUnidade;

    @SerializedName("codigo-unidade")
    @Expose
    private Integer codigoUnidade;

    @SerializedName("nome-unidade")
    @Expose
    private String nomeUnidade;

    @SerializedName("sigla")
    @Expose
    private String sigla;

    @SerializedName("id-nivel-organizacional")
    @Expose
    private Integer idNivelOrganizacional;

    @SerializedName("id-classificacao-unidade")
    @Expose
    private Integer idClassificacaoUnidade;

    @SerializedName("unidade-patrimonial")
    @Expose
    private Boolean unidadePatrimonial;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("telefones")
    @Expose
    private String telefones;

    @SerializedName("id-municipio")
    @Expose
    private Integer idMunicipio;

    @SerializedName("id-ambiente-organizacional")
    @Expose
    private Integer idAmbienteOrganizacional;

    @SerializedName("id-tipo-unidade-organizacional")
    @Expose
    private Integer idTipoUnidadeOrganizacional;

    @SerializedName("data-criacao")
    @Expose
    private Integer dataCriacao;

    @SerializedName("id-area-atuacao-unidade")
    @Expose
    private Integer idAreaAtuacaoUnidade;

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public Integer getCodigoUnidade() {
        return codigoUnidade;
    }

    public void setCodigoUnidade(Integer codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }

    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getIdNivelOrganizacional() {
        return idNivelOrganizacional;
    }

    public void setIdNivelOrganizacional(Integer idNivelOrganizacional) {
        this.idNivelOrganizacional = idNivelOrganizacional;
    }

    public Integer getIdClassificacaoUnidade() {
        return idClassificacaoUnidade;
    }

    public void setIdClassificacaoUnidade(Integer idClassificacaoUnidade) {
        this.idClassificacaoUnidade = idClassificacaoUnidade;
    }

    public Boolean getUnidadePatrimonial() {
        return unidadePatrimonial;
    }

    public void setUnidadePatrimonial(Boolean unidadePatrimonial) {
        this.unidadePatrimonial = unidadePatrimonial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefones() {
        return telefones;
    }

    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Integer getIdAmbienteOrganizacional() {
        return idAmbienteOrganizacional;
    }

    public void setIdAmbienteOrganizacional(Integer idAmbienteOrganizacional) {
        this.idAmbienteOrganizacional = idAmbienteOrganizacional;
    }

    public Integer getIdTipoUnidadeOrganizacional() {
        return idTipoUnidadeOrganizacional;
    }

    public void setIdTipoUnidadeOrganizacional(Integer idTipoUnidadeOrganizacional) {
        this.idTipoUnidadeOrganizacional = idTipoUnidadeOrganizacional;
    }

    public Integer getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Integer dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getIdAreaAtuacaoUnidade() {
        return idAreaAtuacaoUnidade;
    }

    public void setIdAreaAtuacaoUnidade(Integer idAreaAtuacaoUnidade) {
        this.idAreaAtuacaoUnidade = idAreaAtuacaoUnidade;
    }

}