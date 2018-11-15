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
