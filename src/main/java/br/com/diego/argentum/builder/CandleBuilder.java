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
package br.com.diego.argentum.builder;

import java.util.Calendar;

import br.com.diego.argentum.modelo.Candle;

public class CandleBuilder {
    private double abertura;
    private double fechamento;
    private double minimo;
    private double maximo;
    private double volume;
    private Calendar data;

    public CandleBuilder comAbertura(double abertura) {
        this.abertura = abertura;
        return this;
    }

    public CandleBuilder comFechamento(double fechamento) {
        this.fechamento = fechamento;
        return this;
    }

    public CandleBuilder comValorMinimo(double valorMinimo) {
        this.minimo = valorMinimo;
        return this;
    }

    public CandleBuilder comValorMaximo(double maximo) {
        this.maximo = maximo;
        return this;
    }

    public CandleBuilder comVolume(double volume) {
        this.volume = volume;
        return this;
    }

    public CandleBuilder comData(Calendar data) {
        this.data = data;
        return this;
    }

    public Candle geraCandle() {
        return new Candle(abertura, fechamento, minimo, maximo, volume, data);
    }
}
