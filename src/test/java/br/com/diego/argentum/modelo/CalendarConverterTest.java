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

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.diego.argentum.xstream.CalendarConverter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class CalendarConverterTest {

    @Test
    public void deveGerarOXmlComADataAdequada() {

        String resultadoExperado = "<negociacao>\n" +
                "  <preco>40.5</preco>\n" +
                "  <quantidade>100</quantidade>\n" +
                "  <data>\n" +
                "    <time>02/11/2018 14:36:13</time>\n" +
                "    <timezone>America/Bahia</timezone>\n" +
                "  </data>\n" +
                "</negociacao>";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.NOVEMBER, 2, 14, 36, 13);

        Negociacao negociacao = new Negociacao(40.5, 100, calendar);

        XStream stream = new XStream(new DomDriver());
        stream.alias("negociacao", Negociacao.class);
        stream.registerLocalConverter(Negociacao.class, "data", new CalendarConverter());
        String resultado = stream.toXML(negociacao);

        assertEquals(resultadoExperado, resultado);
    }

    @Test
    public void deveGerarObjetoAdequadoDeUmXml() {

        String xml = "<negociacao>\n" +
                "  <preco>40.5</preco>\n" +
                "  <quantidade>100</quantidade>\n" +
                "  <data>\n" +
                "    <time>02/11/2018 14:36:13</time>\n" +
                "    <timezone>America/Bahia</timezone>\n" +
                "  </data>\n" +
                "</negociacao>";

        XStream stream = new XStream(new DomDriver());
        stream.alias("negociacao", Negociacao.class);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.NOVEMBER, 2, 14, 36, 13);

        stream.registerLocalConverter(Negociacao.class, "data", new CalendarConverter());
        Negociacao negociacaoGerada = (Negociacao) stream.fromXML(xml);

        Negociacao negociacaoEsperada = new Negociacao(40.5, 100, calendar);
        System.out.println(negociacaoEsperada.toString());
        System.out.println(negociacaoGerada.toString());

        Assert.assertEquals(negociacaoEsperada, negociacaoGerada);
    }
}
