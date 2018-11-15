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
package br.com.diego.argentum.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import br.com.diego.argentum.modelo.Negociacao;
import br.com.diego.argentum.reader.LeitorXML;

public class ClienteWebService {
    private static final String URL_WEBSERVICE =
            "https://argentumws-spring.herokuapp.com/negociacoes";

    public List<Negociacao> getNegociacoes() {
        HttpURLConnection connection = null;

        try {
            URL url = new URL(URL_WEBSERVICE);
            connection = (HttpURLConnection) url.openConnection();
            InputStream content = connection.getInputStream();

            return new LeitorXML().carrega(content);
        } catch (IOException e) {
            System.out.println("Erro na chamado do servico.");
            return null;
        } finally {
            connection.disconnect();
        }
    }
}
