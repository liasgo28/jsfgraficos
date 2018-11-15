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
package br.com.diego.argentum.modelo;

import java.util.Calendar;

public final class Candle {
    private final double abertura;
    private final double fechamento;
    private final double minimo;
    private final double maximo;
    private final double volume;
    private final Calendar data;

    public Candle(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
        if (minimo > maximo) {
            throw new IllegalArgumentException("O minimo n�o pode ser maior que o maximo");
        }

        this.abertura = abertura;
        this.fechamento = fechamento;
        this.minimo = minimo;
        this.maximo = maximo;
        this.volume = volume;
        this.data = data;
    }

    public final double getAbertura() {
        return abertura;
    }

    public final double getFechamento() {
        return fechamento;
    }

    public final double getMinimo() {
        return minimo;
    }

    public final double getMaximo() {
        return maximo;
    }

    public final double getVolume() {
        return volume;
    }

    public final Calendar getData() {
        return data;
    }

    public boolean isAlta() {
        return this.abertura <= this.fechamento;
    }

    public boolean isBaixa() {
        return this.abertura > this.fechamento;
    }

}
