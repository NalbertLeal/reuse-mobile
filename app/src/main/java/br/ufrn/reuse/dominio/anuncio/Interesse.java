package br.ufrn.reuse.dominio.anuncio;

import java.util.Date;
import java.util.List;

import br.ufrn.reuse.dominio.comum.Usuario;

/**
 * Classe que representa um interesse em um anúncio.
 *
 * @author Daniel
 */
public class Interesse {

    /**
     * Identificador.
     */
    private Long id = null;

    /**
     * Atributo que representa o usuário que está interessado no anúncio.
     */
    private Usuario interessado;

    /**
     * Data de cadastro do interesse.
     */
    private Date dataInteresse;
    /**
     * Anúncio do interesse.
     */
    private Anuncio anuncio;

    /**
     * Data que o interesse foi aprovado.
     */
    private Date dataAprovacao;

    /**
     * Status atual do interesse.
     */
    private StatusInteresse status;

    /**
     * Históricos do interesse.
     */
    private List<HistoricoInteresse> historicoInteresse;

    //GETTERS && SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getInteressado() {
        return interessado;
    }

    public void setInteressado(Usuario interessado) {
        this.interessado = interessado;
    }

    public Date getDataInteresse() {
        return dataInteresse;
    }

    public void setDataInteresse(Date dataInteresse) {
        this.dataInteresse = dataInteresse;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public StatusInteresse getStatus() {
        return status;
    }

    public void setStatus(StatusInteresse status) {
        this.status = status;
    }

    public List<HistoricoInteresse> getHistoricoInteresse() {
        return historicoInteresse;
    }

    public void setHistoricoInteresse(List<HistoricoInteresse> historicoInteresse) {
        this.historicoInteresse = historicoInteresse;
    }
}
