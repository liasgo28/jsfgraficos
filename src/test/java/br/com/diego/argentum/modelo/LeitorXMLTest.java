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

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.diego.argentum.reader.LeitorXML;

public class LeitorXMLTest {
    @Test
    public void carregaXMLComUmaNegociacaoApenas() {
        String xmlDeTeste = "<list>\n" +
                "  <negociacao>\n" +
                "    <preco>40.5</preco>\n" +
                "    <quantidade>100</quantidade>\n" +
                "    <data>\n" +
                "    <time>02/11/2018 14:36:13</time>\n" +
                "    <timezone>America/Bahia</timezone>\n" +
                "    </data>\n" +
                "  </negociacao>\n" +
                "</list>";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.NOVEMBER, 2, 14, 36, 13);
        Negociacao negociacaoEsperada = new Negociacao(40.5, 100, calendar);

        LeitorXML leitor = new LeitorXML();

        InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());

        List<Negociacao> negociacoes = leitor.carrega(xml);

        assertEquals(1, negociacoes.size());
        assertEquals(negociacaoEsperada, negociacoes.get(0));
    }
}
