package br.ufrn.reuse.dominio.anuncio;

/**
 * Classe que representa o status de um interesse.
 *
 * @author Daniel
 *
 */
public class StatusInteresse {

    private String identificador;
    private String descricao;

    public StatusInteresse() {
    }

    public StatusInteresse(String identificador, String descricao) {
        this.identificador = identificador;
        this.descricao = descricao;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
