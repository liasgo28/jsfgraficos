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
package br.com.diego.argentum.mock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.diego.argentum.modelo.Negociacao;

public class ListaNegociacaoMock {
    private final List<Negociacao> negociacoes;

    public ListaNegociacaoMock() {
        super();
        this.negociacoes = new ArrayList<Negociacao>();
        for (int i = 1; i <= 20; i++) {
            Negociacao negociacao = new Negociacao(i, i, Calendar.getInstance());
            this.negociacoes.add(negociacao);
        }

        for (int i = 1; i <= 10; i++) {
            Calendar data = Calendar.getInstance();
            data.add(Calendar.DAY_OF_MONTH, 1);
            Negociacao negociacao = new Negociacao(i, i, data);
            this.negociacoes.add(negociacao);
        }

        for (int i = 1; i <= 9; i++) {
            Calendar data = Calendar.getInstance();
            data.add(Calendar.DAY_OF_MONTH, 2);
            Negociacao negociacao = new Negociacao(i, i, data);
            this.negociacoes.add(negociacao);
        }

        for (int i = 1; i <= 8; i++) {
            Calendar data = Calendar.getInstance();
            data.add(Calendar.DAY_OF_MONTH, 3);
            Negociacao negociacao = new Negociacao(i, i, data);
            this.negociacoes.add(negociacao);
        }

        for (int i = 1; i <= 8; i++) {
            Calendar data = Calendar.getInstance();
            data.add(Calendar.DAY_OF_MONTH, -3);
            Negociacao negociacao = new Negociacao(i, i, data);
            this.negociacoes.add(negociacao);
        }
    }

    public List<Negociacao> getNegociacoes() {
        return negociacoes;
    }
}
