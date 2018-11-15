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
