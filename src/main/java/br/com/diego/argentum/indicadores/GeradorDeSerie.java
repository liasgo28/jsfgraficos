/*
 * ====================================================================
 * Direitos de c�pia pela BRASILPREV
 * 
 * Todos os direitos reservados.
 * 
 * Este sistema cont�m informa��es confidenciais e de propriedade da
 * BRASILPREV ("Informa��es Confidenciais").
 * Voc� n�o deve divulgar tais informa��es confidenciais e deve
 * us�-las somente em conformidade com os termos do contrato de licen�a
 * definidos pela BRASILPREV.
 * ==================================================================== 
 */
package br.com.diego.argentum.indicadores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.diego.argentum.modelo.Candle;
import br.com.diego.argentum.modelo.SerieTemporal;

public class GeradorDeSerie {
    public static SerieTemporal criaSerie(double... valores) {
        List<Candle> candles = new ArrayList<>();
        for (double d : valores) {
            candles.add(new Candle(d, d, d, d, 1000, Calendar.getInstance()));
        }
        return new SerieTemporal(candles);
    }
}
