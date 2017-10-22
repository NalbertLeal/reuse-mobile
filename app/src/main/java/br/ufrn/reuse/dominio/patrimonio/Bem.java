package br.ufrn.reuse.dominio.patrimonio;

/**
 * Classe que representa um bem.
 *
 * @author Daniel
 */
public class Bem {

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
}
