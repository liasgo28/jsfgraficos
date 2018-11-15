/*
 * ====================================================================
 * Direitos de cópia pela BRASILPREV
 * 
 * Todos os direitos reservados.
 * 
 * Este sistema contém informações confidenciais e de propriedade da
 * BRASILPREV ("Informações Confidenciais").
 * Você não deve divulgar tais informações confidenciais e deve
 * usá-las somente em conformidade com os termos do contrato de licença
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
