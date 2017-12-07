package br.ufrn.reuse.remote.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Daniel on 11/19/2017.
 */

public class UsuarioDTO {

    @SerializedName("id-usuario")
    @Expose
    private Integer idUsuario;

    @SerializedName("id-unidade")
    @Expose
    private Integer idUnidade;

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("nome-pessoa")
    @Expose
    private String nomePessoa;

    @SerializedName("cpf-cnpj")
    @Expose
    private Integer cpfCnpj;

    @SerializedName("ativo")
    @Expose
    private Boolean ativo;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("id-foto")
    @Expose
    private Object idFoto;

    @SerializedName("chave-foto")
    @Expose
    private Object chaveFoto;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public Integer getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(Integer cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Object idFoto) {
        this.idFoto = idFoto;
    }

    public Object getChaveFoto() {
        return chaveFoto;
    }

    public void setChaveFoto(Object chaveFoto) {
        this.chaveFoto = chaveFoto;
    }

}
