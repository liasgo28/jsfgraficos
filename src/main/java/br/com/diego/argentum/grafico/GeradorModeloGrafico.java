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
package br.com.diego.argentum.grafico;

import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.diego.argentum.indicadores.Indicador;
import br.com.diego.argentum.modelo.SerieTemporal;

public class GeradorModeloGrafico {
    private final SerieTemporal serie;
    private final int comeco;
    private final int fim;
    private final LineChartModel modeloGrafico;

    public void plotaIndicador(Indicador indicador) {
        LineChartSeries linha = new LineChartSeries();
        linha.setLabel(indicador.toString());
        for (int i = comeco; i <= fim; i++) {
            double valor = indicador.calcula(i, serie);
            linha.set(i, valor);
        }
        this.modeloGrafico.addSeries(linha);
    }

    public GeradorModeloGrafico(SerieTemporal serie, int comeco, int fim) {
        this.serie = serie;
        this.comeco = comeco;
        this.fim = fim;
        this.modeloGrafico = new LineChartModel();

        this.modeloGrafico.setTitle("Indicadores");
        this.modeloGrafico.setLegendPosition("w");
    }

    public LineChartModel getModeloGrafico() {
        return modeloGrafico;
    }

}
