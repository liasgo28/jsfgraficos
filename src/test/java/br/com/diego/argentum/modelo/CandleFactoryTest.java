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

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

public class CandleFactoryTest {
    @Test
    public void sequenciaSimplesDeNegociacoes() {
        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
        Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
        Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
        Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

        List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

        CandleFactory fabrica = new CandleFactory();
        Candle candle = fabrica.constroiCandleParaData(negociacoes, hoje);

        assertEquals(40.5, candle.getAbertura(), 0.00001);
        assertEquals(42.3, candle.getFechamento(), 0.00001);
        assertEquals(39.8, candle.getMinimo(), 0.00001);
        assertEquals(45.0, candle.getMaximo(), 0.00001);
        assertEquals(16760.0, candle.getVolume(), 0.00001);
    }
}
