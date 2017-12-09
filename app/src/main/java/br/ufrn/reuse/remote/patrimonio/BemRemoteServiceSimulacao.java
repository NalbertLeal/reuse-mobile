package br.ufrn.reuse.remote.patrimonio;

import android.content.Context;

import br.ufrn.reuse.dominio.patrimonio.Bem;

/**
 * Implementação do serviço remoto de bens.
 *
 * @author Daniel
 * @author Nalbert
 */
public class BemRemoteServiceSimulacao implements BemRemoteService {

    private final Context context;

    public BemRemoteServiceSimulacao(Context context) {
        this.context = context;
    }

    @Override
    public Bem findBemById(Long idBem) {

        Bem bem = new Bem();

        bem.setId(idBem);
        bem.setNumTombamento(201700000+idBem.intValue());
        bem.setObservacoes("Novo.");
        if(idBem%2==1) {
            bem.setDenominacao("Cadeira vermelha padrão jogos");
        }else{
            bem.setDenominacao("Computador semi-novo.");
        }

        return bem;
    }

    @Override
    public Bem findByTombamento(int numTombamento) {
        Bem bem = null;

        String tombamento = String.valueOf(numTombamento);

        if(tombamento.length() == 10) {
            int anoTombamento = Integer.parseInt(tombamento.substring(0, 4));

            if (anoTombamento > 1950 && anoTombamento < 2017) {
                bem = new Bem();

                bem.setId(1L);
                bem.setDenominacao("Computador HP");
                bem.setNumTombamento(numTombamento);

            }
        }

        return bem;
    }
}
