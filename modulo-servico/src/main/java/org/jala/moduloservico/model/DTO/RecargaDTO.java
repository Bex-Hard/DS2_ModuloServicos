package org.jala.moduloservico.model.DTO;

import org.jala.moduloservico.model.enums.Operadoras;
/**
 * Classe DTO (Data Transfer Object) para transferência de dados de recarga de celular.
 */
public class RecargaDTO {
    /**
     * Atributos
     */
    private double valor;

    /**
     * getters e setters
     * @return
     */
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
