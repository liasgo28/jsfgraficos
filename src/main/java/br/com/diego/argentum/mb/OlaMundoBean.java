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
package br.com.diego.argentum.mb;

import javax.faces.bean.ManagedBean;

/**
 * Class OlaMundoBean.
 * 
 * @author Diego Rodrigues do Nascimento (P51701802)
 */
@ManagedBean
public class OlaMundoBean {

    /** nome. */
    private String nome;

    /**
     * Diga oi.
     * 
     * @return String
     */
    public String digaOi() {
        return "Oi, " + this.getNome();
    }

    /**
     * Retorna o nome.
     * 
     * @return nome
     */
    public final String getNome() {
        return nome;
    }

    /**
     * Atribui valor a nome.
     * 
     * @param nome atribui novo valor a nome
     */
    public final void setNome(String nome) {
        this.nome = nome;
    }
}
