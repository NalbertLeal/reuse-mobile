package br.ufrn.reuse.facade;

import android.content.Context;
import android.support.annotation.NonNull;

import br.ufrn.reuse.dominio.patrimonio.Bem;
import br.ufrn.reuse.repository.patrimonio.BemRepository;

/**
 * Created by Daniel on 11/3/2017.
 */

public class PatrimonioFacade {

    private BemRepository bemRepository;

    public PatrimonioFacade(Context context) {
        this.bemRepository = new BemRepository(context);
    }

    public Bem findByTombamento(int numTombamento){
        return bemRepository.findByTombamento(numTombamento);
    }
}
