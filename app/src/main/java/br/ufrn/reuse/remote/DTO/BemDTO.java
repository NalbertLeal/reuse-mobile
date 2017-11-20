package br.ufrn.reuse.remote.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Daniel on 11/19/2017.
 */

public class BemDTO implements Serializable {

    @SerializedName("id-bem")
    @Expose
    private Integer idBem;

    @SerializedName("numero-tombamento")
    @Expose
    private Integer numeroTombamento;

    @SerializedName("denominacao-bem")
    @Expose
    private String denominacaoBem;

    @SerializedName("id-unidade-responsavel-atual")
    @Expose
    private Integer idUnidadeResponsavelAtual;

    @SerializedName("nome-unidade-responsavel-atual")
    @Expose
    private String nomeUnidadeResponsavelAtual;

    @SerializedName("id-unidade-gestora-tombamento")
    @Expose
    private Integer idUnidadeGestoraTombamento;

    @SerializedName("nome-unidade-gestora-tombamento")
    @Expose
    private String nomeUnidadeGestoraTombamento;

    @SerializedName("id-status-bem")
    @Expose
    private Integer idStatusBem;

    @SerializedName("id-local")
    @Expose
    private Object idLocal;

    @SerializedName("nome-local")
    @Expose
    private Object nomeLocal;

    @SerializedName("especificacao")
    @Expose
    private String especificacao;

    @SerializedName("id-estado-bem")
    @Expose
    private Integer idEstadoBem;

    @SerializedName("bem-terceiros")
    @Expose
    private Boolean bemTerceiros;

    @SerializedName("observacao")
    @Expose
    private Object observacao;

    @SerializedName("id-status-movimentacao")
    @Expose
    private Integer idStatusMovimentacao;

    @SerializedName("anulado")
    @Expose
    private Boolean anulado;

    @SerializedName("id-bem-pai")
    @Expose
    private Object idBemPai;

    @SerializedName("nome-bem-pai")
    @Expose
    private Object nomeBemPai;

    @SerializedName("id-material")
    @Expose
    private Integer idMaterial;

    @SerializedName("nome-material")
    @Expose
    private String nomeMaterial;

    @SerializedName("id-grupo-material")
    @Expose
    private Integer idGrupoMaterial;

    @SerializedName("id-sub-grupo-material")
    @Expose
    private Object idSubGrupoMaterial;

    @SerializedName("data-cadastro")
    @Expose
    private Integer dataCadastro;

    @SerializedName("data-inicio-uso")
    @Expose
    private Integer dataInicioUso;

    @SerializedName("intangivel")
    @Expose
    private Boolean intangivel;

    public Integer getIdBem() {
        return idBem;
    }

    public void setIdBem(Integer idBem) {
        this.idBem = idBem;
    }

    public Integer getNumeroTombamento() {
        return numeroTombamento;
    }

    public void setNumeroTombamento(Integer numeroTombamento) {
        this.numeroTombamento = numeroTombamento;
    }

    public String getDenominacaoBem() {
        return denominacaoBem;
    }

    public void setDenominacaoBem(String denominacaoBem) {
        this.denominacaoBem = denominacaoBem;
    }

    public Integer getIdUnidadeResponsavelAtual() {
        return idUnidadeResponsavelAtual;
    }

    public void setIdUnidadeResponsavelAtual(Integer idUnidadeResponsavelAtual) {
        this.idUnidadeResponsavelAtual = idUnidadeResponsavelAtual;
    }

    public String getNomeUnidadeResponsavelAtual() {
        return nomeUnidadeResponsavelAtual;
    }

    public void setNomeUnidadeResponsavelAtual(String nomeUnidadeResponsavelAtual) {
        this.nomeUnidadeResponsavelAtual = nomeUnidadeResponsavelAtual;
    }

    public Integer getIdUnidadeGestoraTombamento() {
        return idUnidadeGestoraTombamento;
    }

    public void setIdUnidadeGestoraTombamento(Integer idUnidadeGestoraTombamento) {
        this.idUnidadeGestoraTombamento = idUnidadeGestoraTombamento;
    }

    public String getNomeUnidadeGestoraTombamento() {
        return nomeUnidadeGestoraTombamento;
    }

    public void setNomeUnidadeGestoraTombamento(String nomeUnidadeGestoraTombamento) {
        this.nomeUnidadeGestoraTombamento = nomeUnidadeGestoraTombamento;
    }

    public Integer getIdStatusBem() {
        return idStatusBem;
    }

    public void setIdStatusBem(Integer idStatusBem) {
        this.idStatusBem = idStatusBem;
    }

    public Object getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Object idLocal) {
        this.idLocal = idLocal;
    }

    public Object getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(Object nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public Integer getIdEstadoBem() {
        return idEstadoBem;
    }

    public void setIdEstadoBem(Integer idEstadoBem) {
        this.idEstadoBem = idEstadoBem;
    }

    public Boolean getBemTerceiros() {
        return bemTerceiros;
    }

    public void setBemTerceiros(Boolean bemTerceiros) {
        this.bemTerceiros = bemTerceiros;
    }

    public Object getObservacao() {
        return observacao;
    }

    public void setObservacao(Object observacao) {
        this.observacao = observacao;
    }

    public Integer getIdStatusMovimentacao() {
        return idStatusMovimentacao;
    }

    public void setIdStatusMovimentacao(Integer idStatusMovimentacao) {
        this.idStatusMovimentacao = idStatusMovimentacao;
    }

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }

    public Object getIdBemPai() {
        return idBemPai;
    }

    public void setIdBemPai(Object idBemPai) {
        this.idBemPai = idBemPai;
    }

    public Object getNomeBemPai() {
        return nomeBemPai;
    }

    public void setNomeBemPai(Object nomeBemPai) {
        this.nomeBemPai = nomeBemPai;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNomeMaterial() {
        return nomeMaterial;
    }

    public void setNomeMaterial(String nomeMaterial) {
        this.nomeMaterial = nomeMaterial;
    }

    public Integer getIdGrupoMaterial() {
        return idGrupoMaterial;
    }

    public void setIdGrupoMaterial(Integer idGrupoMaterial) {
        this.idGrupoMaterial = idGrupoMaterial;
    }

    public Object getIdSubGrupoMaterial() {
        return idSubGrupoMaterial;
    }

    public void setIdSubGrupoMaterial(Object idSubGrupoMaterial) {
        this.idSubGrupoMaterial = idSubGrupoMaterial;
    }

    public Integer getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Integer dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getDataInicioUso() {
        return dataInicioUso;
    }

    public void setDataInicioUso(Integer dataInicioUso) {
        this.dataInicioUso = dataInicioUso;
    }

    public Boolean getIntangivel() {
        return intangivel;
    }

    public void setIntangivel(Boolean intangivel) {
        this.intangivel = intangivel;
    }
}
