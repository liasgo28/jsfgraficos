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

import org.junit.Assert;
import org.junit.Test;

import br.com.diego.argentum.modelo.SerieTemporal;

public class MediaMovelPonderadaTest {
    @Test
    public void sequeciaSimplesDeCandles() {
        SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 5, 6);
        MediaMovelPonderada mmp = new MediaMovelPonderada(new IndicadorFechamento());
        Assert.assertEquals(14.0 / 6, mmp.calcula(2, serie), 0.00001);
        Assert.assertEquals(20.0 / 6, mmp.calcula(3, serie), 0.00001);
        Assert.assertEquals(26.0 / 6, mmp.calcula(4, serie), 0.00001);
        Assert.assertEquals(32.0 / 6, mmp.calcula(5, serie), 0.00001);
    }
}
