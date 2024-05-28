package org.jala.moduloservico.model;

public class CartaoDebito extends Cartao {

    private ContaCorrente contaCorrente;

    public CartaoDebito(String numero, ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public boolean usarDebito(double valor) {
        return contaCorrente.retirarDinheiro(valor);
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }
}