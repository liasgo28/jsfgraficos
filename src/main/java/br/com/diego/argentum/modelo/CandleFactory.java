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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Uma fábrica de criação de objetos Candle.
 */
public class CandleFactory {

    /**
     * Constroi candle para data.
     * 
     * @param negociacoes do tipo List<Negociacao>
     * @param data do tipo Calendar
     * @return Candle
     */
    public Candle constroiCandleParaData(List<Negociacao> negociacoes, Calendar data) {
        double abertura = negociacoes.get(0).getPreco();
        double fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();

        double minimo = negociacoes.get(0).getPreco();
        double maximo = negociacoes.get(0).getPreco();

        double volume = 0;

        for (Negociacao negociacao : negociacoes) {
            volume += negociacao.getVolume();
            double preco = negociacao.getPreco();
            if (preco > maximo) {
                maximo = preco;
            } else if (preco < minimo) {
                minimo = preco;
            }
        }

        return new Candle(abertura, fechamento, minimo, maximo, volume, data);
    }

    /**
     * Constroi candles.
     * 
     * @param negociacoes do tipo List<Negociacao>
     * @return List
     */
    public List<Candle> constroiCandles(List<Negociacao> negociacoes) {

        // Cria a lista de negociações do dia e a lista de Candles que devemos retornar
        List<Candle> candlesticks = new ArrayList<>();

        List<Negociacao> negociacoesDoDia = new ArrayList<>();

        Calendar dataAtual = negociacoes.get(0).getData();

        // Vamos percorrendo a lista com todas as negociacoes.
        for (Negociacao negociacao : negociacoes) {
            // se for mesmo dia, adiciona na lista de Negociacoes daquele dia
            if (negociacao.isMesmoDia(dataAtual)) {
                negociacoesDoDia.add(negociacao);
            } else {
                // se não for mesmo dia, fecha o candle e reinicia variáveis
                geraEAdiocionaCandle(candlesticks, negociacoesDoDia, dataAtual);

                negociacoesDoDia = new ArrayList<>();

                // Aqui precisamos adicionar o item que caiu no else na nova lista, caso constrário só serão adicionados os itens das próximas
                // iterações.
                negociacoesDoDia.add(negociacao);
                dataAtual = negociacao.getData();
            }

        }
        geraEAdiocionaCandle(candlesticks, negociacoesDoDia, dataAtual);

        return candlesticks;
    }

    /**
     * Gera E adiociona candle.
     * 
     * @param candlesticks do tipo List<Candle>
     * @param negociacoesDoDia do tipo List<Negociacao>
     * @param dataAtual do tipo Calendar
     */
    private void geraEAdiocionaCandle(List<Candle> candlesticks, List<Negociacao> negociacoesDoDia, Calendar dataAtual) {
        Candle candleDodia = constroiCandleParaData(negociacoesDoDia, dataAtual);
        candlesticks.add(candleDodia);
    }
}
