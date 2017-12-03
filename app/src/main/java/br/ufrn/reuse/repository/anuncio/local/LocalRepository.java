package br.ufrn.reuse.repository.anuncio.local;

import android.content.Context;

import br.ufrn.reuse.repository.local.config.SqlHelper;

/**
 * Created by Tek on 03/12/2017.
 */

public class LocalRepository {
    protected final Context context;
    protected SqlHelper sqlHelper;

    public LocalRepository(Context context) {
        this.context = context;
        this.sqlHelper = new SqlHelper(context);
    }
}
