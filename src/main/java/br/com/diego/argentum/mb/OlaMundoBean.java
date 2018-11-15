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
