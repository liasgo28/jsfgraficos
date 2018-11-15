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
package br.com.diego.argentum.mb;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean
public class EstudoBean {

    private final LineChartModel modeloGrafico;
    int[] horasDeEstudo = { 3, 2, 1, 5, 4, 3, 2 };

    public EstudoBean() {
        this.modeloGrafico = new LineChartModel();
        LineChartSeries linha = new LineChartSeries();
        for (int i = 0; i < horasDeEstudo.length; i++) {
            linha.set(i + 1, horasDeEstudo[i]);
        }
        this.modeloGrafico.addSeries(linha);

    }

    public LineChartModel getModeloGrafico() {
        return this.modeloGrafico;
    }
}
