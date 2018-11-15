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
            throw new IllegalArgumentException("O minimo não pode ser maior que o maximo");
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
