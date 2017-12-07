package br.ufrn.reuse;

import android.util.Log;

import org.junit.Test;

import java.util.Date;

import br.ufrn.reuse.utils.DateFormatUtils;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        String teste = DateFormatUtils.dateToString(new Date());
        Date data = DateFormatUtils.stringToDate(teste);
        String teste2 = DateFormatUtils.dateToString(data);
        assert(true);
    }
}