package br.ufrn.reuse.dominio.comum;

/**
 * Classe que representa um servidor.
 *
 * @author Daniel
 */

public class Servidor {

    /**
     * Identificador do servidor.
     */
    private Long id;

    /** Matrícula do servidor */
    private int siape;

    /** Digito da matricula do servidor*/
    private Character digitoSiape;

    /**
     * Retorna o siape do usuário, concatenando o dígito.
     * @return
     */
    public String getSiapeCompleto(){
        return String.valueOf(siape) + "-" + String.valueOf(digitoSiape);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSiape() {
        return siape;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }

    public Character getDigitoSiape() {
        return digitoSiape;
    }

    public void setDigitoSiape(Character digitoSiape) {
        this.digitoSiape = digitoSiape;
    }
}
