package br.ufrn.reuse.dominio.patrimonio;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe que representa um bem.
 *
 * @author Daniel
 */
public class Bem implements Serializable{

    public Bem(){}

    public Bem(Long id, String denominacao, int numTombamento){
        this.id = id;
        this.denominacao = denominacao;
        this.numTombamento = numTombamento;
    }
    /**
     * Identificador do bem.
     */
    private Long id;

    /** Denominação do bem */
    private String denominacao;

    /**
     * O número do tombamento do bem.
     */
    private int numTombamento;

    /** Observações do bem */
    private String observacoes;

    /**
     * Data que o registro foi sincronizado no banco local.
     */
    private Date dataSincronizacao;

    //GETTERS && SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenominacao() {
        return denominacao;
    }

    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }

    public int getNumTombamento() {
        return numTombamento;
    }

    public void setNumTombamento(int numTombamento) {
        this.numTombamento = numTombamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getDataSincronizacao() {
        return dataSincronizacao;
    }

    public void setDataSincronizacao(Date dataSincronizacao) {
        this.dataSincronizacao = dataSincronizacao;
    }

}
