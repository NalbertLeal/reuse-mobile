package br.ufrn.reuse.remote;

import br.ufrn.reuse.dominio.patrimonio.Bem;

/**
 * Created by nalbertg on 26/10/17.
 */

public class BemRemoteService {
    public Bem findBemById(Long idBem) {

        Bem bem = new Bem();

        bem.setId(idBem);
        bem.setDenominacao("Cadeira vermelha padrão jogos");
        bem.setNumTombamento(2014002213);
        bem.setObservacoes("Novo.");

        return bem;
    }
}
