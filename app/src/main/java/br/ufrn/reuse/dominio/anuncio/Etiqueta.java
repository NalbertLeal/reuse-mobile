package br.ufrn.reuse.dominio.anuncio;

/**
 * Classe que representa uma etiqueta.
 *
 * @author Daniel
 */
public class Etiqueta{

    /**
     * Identificador da etiqueta.
     */
    private Long id;

    /**
     * Nome da etiqueta
     */
    private String nome;

    public Etiqueta(){}

    public Etiqueta(Long id) {
        this.id = id;
    }

    public Etiqueta(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
