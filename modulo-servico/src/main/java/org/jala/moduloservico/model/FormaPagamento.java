package org.jala.moduloservico.model;

public class FormaPagamento {

    /**
     * Atributos comuns
     */
    private double valor;

    /**
     * Atributos específicos para pagamentos com cartão
     */
    private String numeroCartao;
    private String nomeTitular;
    private String validade;
    private String cvv;

    /**
     * Atributos para demais tipos de pagamento
     */

    private String codigoBoleto;  // Para pagamentos com boleto

    private String numeroConta;   // Para pagamentos com saldo em conta

    /**
     * Construtor
     * @param valor
     */
    public FormaPagamento(double valor) {

        this.valor = valor;
    }

    /**
     * getters e setters
     * @return
     */

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Retorna uma representação em formato de String do objeto FormaPagamento.
     * @return Uma String contendo os valores dos atributos da FormaPagamento.
     */
    @Override
    public String toString() {
        return "FormaPagamento{" +
                "valor=" + valor +
                ", numeroCartao='" + numeroCartao + '\'' +
                ", nomeTitular='" + nomeTitular + '\'' +
                ", validade='" + validade + '\'' +
                ", cvv='" + cvv + '\'' +
                ", codigoBoleto='" + codigoBoleto + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                '}';
    }
}

