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
package br.com.diego.argentum;

public enum MediaMovel {
    Simples("MediaMovelSimples"),
    Ponderada("MediaMovelPonderada");

    private final String value;

    private MediaMovel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
