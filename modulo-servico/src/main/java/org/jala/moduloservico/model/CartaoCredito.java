package org.jala.moduloservico.model;

import java.time.LocalDate;
import java.util.Date;

public class CartaoCredito
{
    private long id;
    private String numeroCartao;
    private String cvv;
    private double limite;
    private double saldoUtilizado;
    private LocalDate validade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getNumero() {
        return numeroCartao;
    }

    public void setNumero(String numero) {
        this.numeroCartao = numero;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public CartaoCredito(String numeroCartao, double limite) {

        this.limite = limite;
    }

    public CartaoCredito( ) {

    }

    public boolean usarCredito(double valor) {
        if (saldoUtilizado + valor <= limite) {
            saldoUtilizado += valor;
            return true;
        }
        return false;
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