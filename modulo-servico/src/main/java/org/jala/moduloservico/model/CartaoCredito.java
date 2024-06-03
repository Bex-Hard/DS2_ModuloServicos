package org.jala.moduloservico.model;

import java.time.LocalDate;
import java.util.Date;

public class CartaoCredito
{
    /**
     * Atributos do Cartão de Crédito
     */
    private long id;
    private String numeroCartao;
    private String cvv;
    private double limite;
    private double saldoUtilizado;
    private LocalDate validade;

    /**
     * Construtor
     */
    public CartaoCredito( ) {

    }

    /**
     * Método que cria a regra de negócio para uso do crédito
     * @param valor
     * @return
     */
    public boolean usarCredito(double valor) {
        if (valor <= limite) {
            saldoUtilizado += valor;
            limite -= valor;
            return true;
        }
        return false;
    }
    /**
     * getters e setters
     * @return
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldoUtilizado() {
        return saldoUtilizado;
    }

    public void setSaldoUtilizado(double saldoUtilizado) {
        this.saldoUtilizado = saldoUtilizado;
    }
}