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
package br.com.diego.argentum.reader;

import java.io.InputStream;
import java.util.List;

import br.com.diego.argentum.modelo.Negociacao;
import br.com.diego.argentum.xstream.CalendarConverter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class LeitorXML {
    public List<Negociacao> carrega(InputStream inputStream) {

        XStream stream = new XStream(new DomDriver());
        stream.alias("negociacao", Negociacao.class);
        stream.registerLocalConverter(Negociacao.class, "data", new CalendarConverter());

        return (List<Negociacao>) stream.fromXML(inputStream);
    }
}
