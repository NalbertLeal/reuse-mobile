package br.ufrn.reuse.dominio.anuncio;

/**
 * Classe que representa uma foto de um anúncio.
 *
 * @author Daniel
 */
public class Foto {

    /**
     * Identificador da foto.
     */
    private Long id;

    /**
     * Id do arquivo no banco de arquivos
     * */
    private Long idArquivo;

    /**
     *
     */
    private String urlFoto;

    /**
     * Atributo que mapeia se uma foto é a foto de capa do anúncio.
     */
    private boolean fotoCapa;

    public Foto() {
    }

    public Foto(Long id, Long idArquivo, String urlFoto, boolean fotoCapa) {
        this.id = id;
        this.idArquivo = idArquivo;
        this.urlFoto = urlFoto;
        this.fotoCapa = fotoCapa;
    }

    //TODO: Arquivo para upload.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(Long idArquivo) {
        this.idArquivo = idArquivo;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public boolean isFotoCapa() {
        return fotoCapa;
    }

    public void setFotoCapa(boolean fotoCapa) {
        this.fotoCapa = fotoCapa;
    }

}
