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
package br.com.diego.argentum.modelo;

import java.util.List;

public class SerieTemporal {
    private final List<Candle> candles;

    public SerieTemporal(List<Candle> candles) {
        this.candles = candles;
    }

    public Candle getCandle(int posicao) {
        return candles.get(posicao);
    }

    public int getUltimaPosicao() {
        return candles.size() - 1;
    }
}
