package br.ufrn.reuse.dominio.anuncio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ufrn.reuse.dominio.comum.Unidade;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.dominio.patrimonio.Bem;

/**
 * Classe que representa um anúncio do sistema.
 *
 * @author Daniel
 */
public class Anuncio {

    /**
     * Identificador do anúncio
     */
    private Long id;

    /**
     * Texto da publicação.
     */
    private String textoPublicacao;

    /**
     * Status atual do anúncio.
     */
    private StatusAnuncio statusAnuncio;

    /**
     * Data de cadastro do anúncio.
     */
    private Date dataCadastro;

    /**
     * Data de publicação do anúncio.
     */
    private Date dataPublicacao;

    /**
     * Bem anunciado.
     *
     */
    private Bem bem;

    /**
     * Fotos do anúncio.
     */
    private List<Foto> fotos;

    /**
     * Unidade do anúncio.
     */
    private Unidade unidade;

    /**
     * Categoria do anúncio.
     */
    private CategoriaAnuncio categoria;

    /**
     * Usuário do cadastro do anúncio.
     */
    private Usuario usuario;

    /**
     * Interesses do anúncio.
     */
    private List<Interesse> interesses;

    /**
     * Históricos do anúncio.
     */
    private List<HistoricoAnuncio> historicos;

    /**
     * Quantidade de dias que o anúncio deverá estar ativo, contando a partír da data de publicação.
     */
    private Integer quantidadeDiasAtivo;

    /**
     * Etiquetas associadas ao anúncio.
     */
    private List<Etiqueta> etiquetas;

    /**
     * Atributo que representa a data que o registro foi sincronizado no banco local
     */
    private Date dataSincronizacao;

    //GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextoPublicacao() {
        return textoPublicacao;
    }

    public void setTextoPublicacao(String textoPublicacao) {
        this.textoPublicacao = textoPublicacao;
    }

    public StatusAnuncio getStatusAnuncio() {
        return statusAnuncio;
    }

    public void setStatusAnuncio(StatusAnuncio statusAnuncio) {
        this.statusAnuncio = statusAnuncio;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Bem getBem() {
        return bem;
    }

    public void setBem(Bem bem) {
        this.bem = bem;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public CategoriaAnuncio getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAnuncio categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Interesse> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<Interesse> interesses) {
        this.interesses = interesses;
    }

    public List<HistoricoAnuncio> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<HistoricoAnuncio> historicos) {
        this.historicos = historicos;
    }

    public Integer getQuantidadeDiasAtivo() {
        return quantidadeDiasAtivo;
    }

    public void setQuantidadeDiasAtivo(Integer quantidadeDiasAtivo) {
        this.quantidadeDiasAtivo = quantidadeDiasAtivo;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Date getDataSincronizacao() {
        return dataSincronizacao;
    }

    public void setDataSincronizacao(Date dataSincronizacao) {
        this.dataSincronizacao = dataSincronizacao;
    }

    public List<String> validarCadastro() {
        List<String> erros = new ArrayList<>();

        if(bem == null){
            erros.add("Bem não pode ser nulo.");
        }

        if(usuario == null){
            erros.add("Usuario não pode ser nulo.");
        }

        if(unidade == null){
            erros.add("Unidade não pode ser nula.");
        }

        if(categoria == null){
            erros.add("Selecione uma categoria.");
        }

        return erros;
    }
}
