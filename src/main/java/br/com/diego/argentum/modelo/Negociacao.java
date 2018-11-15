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

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Negociacao {
    private final double preco;

    private final int quantidade;
    private final Calendar data;

    public Negociacao(double preco, int quantidade, Calendar data) {
        if (preco < 0) {
            throw new IllegalArgumentException("Pre�o n�o pode ser negativo");
        }

        if (data == null) {
            throw new IllegalArgumentException("Data n�o pode ser nula");
        }

        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser pelo menos 1");
        }

        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Calendar getData() {
        return data;
    }

    public double getVolume() {
        return preco * quantidade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((data == null) ? 0 : data.hashCode());
        long temp;
        temp = Double.doubleToLongBits(preco);
        result = (prime * result) + (int) (temp ^ (temp >>> 32));
        result = (prime * result) + quantidade;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Negociacao other = (Negociacao) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        }
        if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
            return false;
        if (quantidade != other.quantidade)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Negociacao [preco=" + preco + ", quantidade=" + quantidade + ", data=" + data + "]";
    }

    public boolean isMesmoDia(Calendar mesmoMomento) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(this.data.getTime()).equals(sdf.format(mesmoMomento.getTime()));
    }

}
