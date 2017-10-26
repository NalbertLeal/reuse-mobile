package br.ufrn.reuse.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Classe com operações úteis para avaliar a consistência dos registro.
 *
 * @author Daniel
 */
public class SincronizacaoUtils {

    /**
     * Retorna se o registro está sincronizado no banco local.
     *
     * @param quantidadeDiasSincronizadoBem
     * @return
     */
    public static boolean isSincronizado(Date dataUltimaSincronizacao, int quantidadeDiasSincronizadoBem){
        boolean isSincronizado = false;

        if(dataUltimaSincronizacao == null){
            return false;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataUltimaSincronizacao);
        calendar.add(Calendar.DATE,quantidadeDiasSincronizadoBem);
        Date dataProximaSincronizacao = calendar.getTime();

        Date dataAtual = new Date();

        if(dataProximaSincronizacao.after(dataAtual)){
            isSincronizado = true;
        }

        return isSincronizado;
    }

}
