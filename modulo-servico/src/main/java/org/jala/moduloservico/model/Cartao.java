package org.jala.moduloservico.model;

abstract class Cartao {

    protected String numero;
    protected String cvc;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public Cartao() {

    }

}