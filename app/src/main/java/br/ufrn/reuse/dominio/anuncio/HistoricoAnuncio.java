package br.ufrn.reuse.dominio.anuncio;

import java.util.Date;

import br.ufrn.reuse.dominio.comum.Usuario;

/**
 *  Classe que representa o histórico de uma alteração no interesse.
 *
 *  @author Daniel
 */
public class HistoricoAnuncio{

    /**
     * Identificador do histórico.
     */
    private Long id;

    /**
     * Anúncio associado.
     */
    private Anuncio anuncio;

    /**
     * Status Associado à alteração do histórico.
     */
    private StatusAnuncio statusAnuncio;

    /**
     * Data da alteração do anúncio.
     * Também é a data da criação do histórico.
     *
     */
    private Date dataAlteracao;

    /**
     * Usuário associado ao histórico.
     */
    private Usuario usuario;

    /**
     * Justificativa do cadastro do histórico.
     */
    private String justificativa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public StatusAnuncio getStatusAnuncio() {
        return statusAnuncio;
    }

    public void setStatusAnuncio(StatusAnuncio statusAnuncio) {
        this.statusAnuncio = statusAnuncio;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
}
