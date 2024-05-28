package org.jala.moduloservico.model;

public class CartaoCredito extends Cartao {
    private double limite;
    private double saldoUtilizado;

    public CartaoCredito(String numero, double limite) {

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