package org.jala.moduloservico.model;

public class FormaPagamento {

    // Atributos comuns
    private double valor;

    // Atributos específicos para cada tipo de pagamento
    private String numeroCartao;  // Para pagamentos com cartão
    private String nomeTitular;   // Para pagamentos com cartão
    private String validade;      // Para pagamentos com cartão
    private String cvv;           // Para pagamentos com cartão

    private String chavePix;      // Para pagamentos com PIX

    private String codigoBoleto;  // Para pagamentos com boleto

    private String numeroConta;   // Para pagamentos com saldo em conta

    // Construtor
    public FormaPagamento(double valor) {

        this.valor = valor;
    }

    // Getters e Setters

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getCodigoBoleto() {
        return codigoBoleto;
    }

    public void setCodigoBoleto(String codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    @Override
    public String toString() {
        return "FormaPagamento{" +
                "valor=" + valor +
                ", numeroCartao='" + numeroCartao + '\'' +
                ", nomeTitular='" + nomeTitular + '\'' +
                ", validade='" + validade + '\'' +
                ", cvv='" + cvv + '\'' +
                ", chavePix='" + chavePix + '\'' +
                ", codigoBoleto='" + codigoBoleto + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                '}';
    }
}

