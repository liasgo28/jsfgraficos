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
package br.com.diego.argentum.indicadores;

import br.com.diego.argentum.modelo.SerieTemporal;

public class IndicadorFechamento implements Indicador {
    @Override
    public double calcula(int posicao, SerieTemporal serie) {
        return serie.getCandle(posicao).getFechamento();
    }

    @Override
    public String toString() {
        return "MMP - Fechamento Simples";
    }

}
