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

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.LineChartModel;

import br.com.diego.argentum.grafico.GeradorModeloGrafico;
import br.com.diego.argentum.indicadores.IndicadorAbertura;
import br.com.diego.argentum.indicadores.IndicadorFactory;
import br.com.diego.argentum.indicadores.IndicadorFechamento;
import br.com.diego.argentum.indicadores.IndicadorMaximo;
import br.com.diego.argentum.indicadores.MediaMovelPonderada;
import br.com.diego.argentum.indicadores.MediaMovelSimples;
import br.com.diego.argentum.mock.ListaNegociacaoMock;
import br.com.diego.argentum.modelo.Candle;
import br.com.diego.argentum.modelo.CandleFactory;
import br.com.diego.argentum.modelo.Negociacao;
import br.com.diego.argentum.modelo.SerieTemporal;

@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable {

    private static final long serialVersionUID = -6474190207204604829L;
    private List<Negociacao> negociacoes;
    private LineChartModel modeloGrafico;

    private String nomeMedia;
    private String nomeIndicadorBase;

    public ArgentumBean() {

        try {
            // ClienteWebService cliente = new ClienteWebService();
            // this.negociacoes = cliente.getNegociacoes();
            if (this.negociacoes == null) {
                this.negociacoes = new ListaNegociacaoMock().getNegociacoes();
            }

        } catch (Exception e) {
            this.negociacoes = new ListaNegociacaoMock().getNegociacoes();
        }

        List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
        SerieTemporal serie = new SerieTemporal(candles);

        GeradorModeloGrafico gerador = new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());
        gerador.plotaIndicador(new MediaMovelSimples(new IndicadorFechamento()));
        gerador.plotaIndicador(new MediaMovelPonderada(new IndicadorFechamento()));
        gerador.plotaIndicador(new IndicadorAbertura());
        gerador.plotaIndicador(new IndicadorFechamento());
        gerador.plotaIndicador(new IndicadorMaximo());

        this.modeloGrafico = gerador.getModeloGrafico();
    }

    public void geraGrafico() {
        System.out.println("PLOTANDO: " + nomeMedia + " de " + nomeIndicadorBase);
        List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
        SerieTemporal serie = new SerieTemporal(candles);

        GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());

        try {

            IndicadorFactory fabrica = new IndicadorFactory(nomeMedia, nomeIndicadorBase);
            geradorGrafico.plotaIndicador(fabrica.defineIndicador());

            this.modeloGrafico = geradorGrafico.getModeloGrafico();
        } catch (Exception e) {

        }
    }

    public List<Negociacao> getNegociacoes() {
        return this.negociacoes;
    }

    public LineChartModel getModeloGrafico() {
        return modeloGrafico;
    }

    public String getNomeMedia() {
        return nomeMedia;
    }

    public void setNomeMedia(String nomeMedia) {
        this.nomeMedia = nomeMedia;
    }

    public String getNomeIndicadorBase() {
        return nomeIndicadorBase;
    }

    public void setNomeIndicadorBase(String nomeIndicadorBase) {
        this.nomeIndicadorBase = nomeIndicadorBase;
    }

}
