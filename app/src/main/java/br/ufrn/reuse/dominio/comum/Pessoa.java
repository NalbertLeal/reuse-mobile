package br.ufrn.reuse.dominio.comum;

/**
 * Classe que representa uma pessoa nos sistemas da UFRN.
 *
 * @author Daniel
 */
public class Pessoa {

    /**
     * Id da pessoa no REUSE
     */
    private Long id;

    /**
     * Nome da pessoa.
     */
    private String nome;

    /**
     * Cpf da pessoa.
     */
    private String cpf;

    public Pessoa(){

    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa(String nome) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
