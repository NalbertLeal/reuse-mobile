package br.ufrn.reuse.remote;

import android.support.annotation.NonNull;

import br.ufrn.reuse.dominio.patrimonio.Bem;

/**
 * Implementação do serviço remoto de bens.
 *
 * @author Daniel
 * @author Nalbert
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

    public Bem findByTombamento(int numTombamento) {
        Bem bem = new Bem();

        bem.setId(1L);
        bem.setDenominacao("Cadeira muito boa");
        bem.setNumTombamento(numTombamento);

        return bem;
    }
}
