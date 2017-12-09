package br.ufrn.reuse.dominio.anuncio;

/**
 * Classe que representa uma categoria de anúncio do REUSE.
 *
 * @author Daniel
 */
public class CategoriaAnuncio {

    /**
     * Nome da categoria
     */
    private String identificador;

    /**
     * Descrição da categoria
     */
    private String descricao;

    public CategoriaAnuncio(String identificador) {
        this.identificador = identificador;
    }

    public CategoriaAnuncio(String identificador, String descricao) {
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

    @Override
    public String toString(){
        return descricao;
    }

}
