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
package br.com.diego.argentum;

import br.com.diego.argentum.indicadores.Indicador;
import br.com.diego.argentum.indicadores.IndicadorAbertura;
import br.com.diego.argentum.indicadores.IndicadorFechamento;

public enum Indicadores {
    Abertura("IndicadorAbertura", new IndicadorAbertura()),
    Fechamento("IndicadorFechamento", new IndicadorFechamento());

    private final String value;
    private Indicador indicador;

    private Indicadores(String value, Indicador indicador) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Indicador getIndicador() {
        return indicador;
    }

}
