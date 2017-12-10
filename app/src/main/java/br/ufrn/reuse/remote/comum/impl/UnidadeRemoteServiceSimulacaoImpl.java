package br.ufrn.reuse.remote.comum.impl;

import android.content.Context;

import java.util.Arrays;
import java.util.List;

import br.ufrn.reuse.dominio.comum.Unidade;
import br.ufrn.reuse.remote.comum.UnidadeRemoteService;

/**
 * Created by Daniel on 11/5/2017.
 */

public class UnidadeRemoteServiceSimulacaoImpl implements UnidadeRemoteService {

    private final List<Unidade> unidades;
    private final Context context;

    public UnidadeRemoteServiceSimulacaoImpl(Context context) {
        this.context = context;
        this.unidades = Arrays.asList(new Unidade(1L,1135L,"Superintendencia de Informatica", "SINFO"),new Unidade(2L,1123L,"Departamento de Matemática e Informática Aplicada", "DIMAP"),new Unidade(3L,1102L,"Divisão de material e patrimonio", "DMP"));

    }

    @Override
    public Unidade findUnidadeById(Long idUnidade) {
        for (Unidade unidade : this.unidades) {
            if (unidade.getId().equals(idUnidade)) {
                return unidade;
            }
        }

        return null;
    }
}
