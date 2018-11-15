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
