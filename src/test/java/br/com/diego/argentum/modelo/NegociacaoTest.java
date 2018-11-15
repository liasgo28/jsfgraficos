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

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class NegociacaoTest {

    @Test(expected = IllegalArgumentException.class)
    public void naoCriaNegociacaoComDataNula() {
        new Negociacao(10, 5, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoCriaNegociacaoComPrecoNegativo() {
        new Negociacao(-10, 5, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoCriaNegociacaoComQuantidadeZero() {
        new Negociacao(10, 0, Calendar.getInstance());
    }

    @Test
    public void mesmoSegundoEhDoMesmoDia() {

        Calendar agora = Calendar.getInstance();
        Calendar mesmoMomento = agora;

        Negociacao negociacao = new Negociacao(40.0, 100, agora);
        Assert.assertTrue(negociacao.isMesmoDia(mesmoMomento));
    }

    @Test
    public void comHorariosDiferentesEhNoMesmoDia() {
        Calendar manha = Calendar.getInstance();
        manha.set(2016, 02, 25, 8, 30);

        Calendar tarde = Calendar.getInstance();
        tarde.set(2016, 02, 25, 15, 30);

        Negociacao negociacao = new Negociacao(40.0, 100, manha);
        Assert.assertTrue(negociacao.isMesmoDia(tarde));
    }

    @Test
    public void paraNegociacoesDeTresDiasDistintosGeraTresCandles() {

        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
        Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
        Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
        Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

        Calendar amanha = Calendar.getInstance();
        amanha.add(Calendar.DATE, 1);

        Negociacao negociacao5 = new Negociacao(48.8, 100, amanha);
        Negociacao negociacao6 = new Negociacao(49.3, 100, amanha);

        Calendar depois = Calendar.getInstance();
        depois.add(Calendar.DATE, 2);

        Negociacao negociacao7 = new Negociacao(51.8, 100, depois);
        Negociacao negociacao8 = new Negociacao(52.3, 100, depois);

        List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
                negociacao3, negociacao4, negociacao5, negociacao6, negociacao7,
                negociacao8);

        CandleFactory fabrica = new CandleFactory();

        List<Candle> candles = fabrica.constroiCandles(negociacoes);

        Assert.assertEquals(3, candles.size());
        Assert.assertEquals(40.5, candles.get(0).getAbertura(), 0.00001);
        Assert.assertEquals(42.3, candles.get(0).getFechamento(), 0.00001);
        Assert.assertEquals(48.8, candles.get(1).getAbertura(), 0.00001);
        Assert.assertEquals(49.3, candles.get(1).getFechamento(), 0.00001);
        Assert.assertEquals(51.8, candles.get(2).getAbertura(), 0.00001);
        Assert.assertEquals(52.3, candles.get(2).getFechamento(), 0.00001);
    }
}
