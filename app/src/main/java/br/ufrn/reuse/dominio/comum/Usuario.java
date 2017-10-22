package br.ufrn.reuse.dominio.comum;

import java.util.List;

/**
 * Classe que representa um usuário do sistema
 *
 * @author Daniel
 */
public class Usuario {

    /**
     * Identificador do usuário.
     */
    private Long id;

    /**
     * Login do usuário.
     */
    private String login;

    /**
     * Unidade do usuário.
     */
    private Unidade unidade;

    /**
     * Lista de unidades patrimoniais associadas ao usuário.
     */
    private List<Unidade> unidadesUsuario;

    /**
     * Email do usuário.
     */
    private String email;

    /**
     * Pessoa associada ao usuário.
     */
    private Pessoa pessoa;

    /**
     * Servidor associado ao usuário.
     */
    private Servidor servidor;

    /**
     * Url da foto do usuário na base de arquivos.
     */
    private Integer urlFoto;

    //Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public List<Unidade> getUnidadesUsuario() {
        return unidadesUsuario;
    }

    public void setUnidadesUsuario(List<Unidade> unidadesUsuario) {
        this.unidadesUsuario = unidadesUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Integer getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(Integer urlFoto) {
        this.urlFoto = urlFoto;
    }
}
