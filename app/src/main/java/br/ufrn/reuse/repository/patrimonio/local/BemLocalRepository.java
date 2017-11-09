package br.ufrn.reuse.repository.patrimonio.local;

import android.content.Context;

import br.ufrn.reuse.dominio.patrimonio.Bem;

/**
 * Created by nalbertg on 26/10/17.
 */

public class BemLocalRepository {

    private final Context context;

    public BemLocalRepository(Context context) {
        this.context = context;
    }

    public Bem findBemById(Long idBem) {
        return null;
    }

    public void save(Bem bem) {

    }
}
