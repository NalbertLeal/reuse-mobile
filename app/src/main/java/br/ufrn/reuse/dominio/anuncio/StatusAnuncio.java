package br.ufrn.reuse.dominio.anuncio;

/**
 * Classed que representa um Status do anúncio.
 *
 * @author Daniel
 */
public class StatusAnuncio {

    /**
     * Identificador do status do anúncio.
     */
    private String identificador;

    /**
     * Nome do status do anúncio.
     */
    private String nome;

    public StatusAnuncio(){}

    public StatusAnuncio(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
