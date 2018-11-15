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
