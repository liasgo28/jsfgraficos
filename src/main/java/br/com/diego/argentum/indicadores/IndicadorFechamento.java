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
