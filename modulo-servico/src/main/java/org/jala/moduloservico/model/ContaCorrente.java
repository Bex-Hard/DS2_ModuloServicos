package org.jala.moduloservico.model;

import org.jala.moduloservico.model.enums.TipoServicos;

public class ContaCorrente {
    /**
     * Atributos da Conta Corrente
     */
    private long id;
    private String numeroAgencia;
    private String digitoAgencia;
    private String numeroConta;
    private double saldo;
    private CartaoCredito cartao;
    private String tipoServicos;

    /**
     * Método que cria a lógica e regras de uso do saldo
     * @param valor
     * @return
     */
    public boolean retirarDinheiro(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }


    /**
     * getters e setters
     * @return
     */

    public String getTipoServicos() {
        return tipoServicos;
    }

    public void setTipoServicos(TipoServicos tipoServicos) {
        String tipo = (String.valueOf(tipoServicos));
        this.tipoServicos = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public void setDigitoAgencia(String digitoAgencia) {
        this.digitoAgencia = digitoAgencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public CartaoCredito getCartao() {
        return cartao;
    }

    public void setCartao(CartaoCredito cartao) {
        this.cartao = cartao;
    }
}