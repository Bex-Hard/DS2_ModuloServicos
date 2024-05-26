package org.jala.moduloservico.model;

public class CartaoCredito {
    private String numero;
    private double limite;
    private double saldoUtilizado;

    public CartaoCredito() {
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setSaldoUtilizado(double saldoUtilizado) {
        this.saldoUtilizado = saldoUtilizado;
    }

    public CartaoCredito(String numero, double limite) {
        this.numero = numero;
        this.limite = limite;
        this.saldoUtilizado = 0;
    }

    public String getNumero() {
        return numero;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldoUtilizado() {
        return saldoUtilizado;
    }

    public void fazerCompra(double valor) {
        if (valor + saldoUtilizado <= limite) {
            saldoUtilizado += valor;
        } else {
            System.out.println("Limite insuficiente.");
        }
    }

    public void pagarFatura(double valor) {
        if (valor <= saldoUtilizado) {
            saldoUtilizado -= valor;
        } else {
            System.out.println("Valor maior que o saldo utilizado.");
        }
    }
}