package org.jala.moduloservico.model.DTO;

import org.jala.moduloservico.model.enums.Operadoras;

public class RecargaDTO {
    private double valor;
    private Operadoras operadora;
    private String celularRecarregado;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Operadoras getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadoras operadora) {
        this.operadora = operadora;
    }

    public String getCelularRecarregado() {
        return celularRecarregado;
    }

    public void setCelularRecarregado(String celularRecarregado) {
        this.celularRecarregado = celularRecarregado;
    }
}
