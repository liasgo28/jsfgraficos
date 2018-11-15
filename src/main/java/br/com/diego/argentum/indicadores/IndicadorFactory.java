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
package br.com.diego.argentum.indicadores;

import java.lang.reflect.Constructor;

public class IndicadorFactory {

    private static final String PACOTE = "br.com.diego.argentum.indicadores.";

    private final Indicador indicador;

    public IndicadorFactory(String nomeMedia, String nomeIndicadorBase) throws Exception {

        Class<?> classeIndicadorBase = Class.forName(PACOTE + nomeIndicadorBase);
        Indicador indicadorBase = (Indicador) classeIndicadorBase.newInstance();

        Class<?> classeMedia = Class.forName(PACOTE + nomeMedia);
        Constructor<?> construtorMedia = classeMedia.getConstructor(Indicador.class);
        this.indicador = (Indicador) construtorMedia.newInstance(indicadorBase);
    }

    public Indicador defineIndicador() {
        return this.indicador;
    }

}
