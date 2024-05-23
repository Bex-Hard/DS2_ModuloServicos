package org.jala.moduloservico.model;

public class ContaPoupanca {
    private String numero;
    private double saldo;
    private double taxaDeJuros;

    public ContaPoupanca(String numero, double saldoInicial, double taxaDeJuros) {
        this.numero = numero;
        this.saldo = saldoInicial;
        this.taxaDeJuros = taxaDeJuros;
    }

    public ContaPoupanca() {
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTaxaDeJuros(double taxaDeJuros) {
        this.taxaDeJuros = taxaDeJuros;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaDeJuros() {
        return taxaDeJuros;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void aplicarJuros() {
        saldo += saldo * taxaDeJuros;
    }
}