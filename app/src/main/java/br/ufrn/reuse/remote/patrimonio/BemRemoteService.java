package br.ufrn.reuse.remote.patrimonio;

import android.content.Context;
import android.support.annotation.NonNull;

import br.ufrn.reuse.dominio.patrimonio.Bem;

/**
 * Implementação do serviço remoto de bens.
 *
 * @author Daniel
 * @author Nalbert
 */
public class BemRemoteService {

    private final Context context;

    public BemRemoteService(Context context) {
        this.context = context;
    }

    public Bem findBemById(Long idBem) {

        Bem bem = new Bem();

        bem.setId(idBem);
        bem.setDenominacao("Cadeira vermelha padrão jogos");
        bem.setNumTombamento(2014002213);
        bem.setObservacoes("Novo.");

        return bem;
    }

    public Bem findByTombamento(int numTombamento) {
        Bem bem = null;

        String tombamento = String.valueOf(numTombamento);

        if(tombamento.length() == 10) {
            int anoTombamento = Integer.parseInt(tombamento.substring(0, 3));

            if (anoTombamento > 1950 && anoTombamento < 2017) {
                bem = new Bem();

                bem.setId(1L);
                bem.setDenominacao("Cadeira");
                bem.setNumTombamento(numTombamento);

            }
        }

        return bem;
    }
}
