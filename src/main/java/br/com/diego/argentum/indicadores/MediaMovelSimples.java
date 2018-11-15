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

public class MediaMovelSimples implements Indicador {
    private final Indicador outroIndicador;

    public MediaMovelSimples(Indicador outroIndicador) {
        this.outroIndicador = outroIndicador;
    }

    @Override
    public double calcula(int posicao, SerieTemporal serie) {
        double soma = 0;
        for (int i = posicao; i > (posicao - 3); i--) {
            soma += outroIndicador.calcula(i, serie);
        }
        return soma / 3;
    }

    @Override
    public String toString() {
        return "Media Movel Simples";
    }

}
