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

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.diego.argentum.builder.CandleBuilder;

public class CandleTest {
    @Test(expected = IllegalArgumentException.class)
    public void precoMaximoNaoPodeSerMenorQueMinimo() {
        new CandleBuilder().comAbertura(10)
                .comFechamento(20).comValorMinimo(8).comValorMaximo(5).
                comVolume(100).comData(Calendar.getInstance())
                .geraCandle();
    }

    @Test
    public void quandoAberturaIgualFechamentoEhAlta() {
        Candle candle = new CandleBuilder().comAbertura(20)
                .comFechamento(20).comValorMinimo(8).comValorMaximo(15).comVolume(100)
                .comData(Calendar.getInstance()).geraCandle();

        Assert.assertTrue(candle.isAlta());

    }
}
