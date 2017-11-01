package br.ufrn.reuse.repository.comum;

import android.content.Context;

import br.ufrn.reuse.dominio.comum.Unidade;

/**
 * Created by Daniel on 10/27/2017.
 */

public class UnidadeRepository {
    private final Context context;

    public UnidadeRepository(Context context) {
        this.context = context;
    }

    public Unidade findUnidadeById(Unidade unidade) {
        return null;
    }
}
