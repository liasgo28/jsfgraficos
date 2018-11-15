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
