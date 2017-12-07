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


    @SerializedName("observacao")
    @Expose
    private String observacao;


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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
