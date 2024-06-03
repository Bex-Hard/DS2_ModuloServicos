package org.jala.moduloservico.model.DTO;

import java.time.LocalDate;
/**
 * Classe DTO (Data Transfer Object) para transferência de dados de boleto.
 */
public class BoletoDTO  {
    /**
     * Atributos
     */
    private String valorBoleto;
    private LocalDate dataBoteto;
    private LocalDate dataVencimentoBoleto;

    /**
     * Construtor da classe BoletoDTO.
     *
     * @param valorBoleto o valor do boleto.
     * @param dataBoteto a data do boleto.
     * @param dataVencimento a data de vencimento do boleto.
     */
    public BoletoDTO(String valorBoleto, LocalDate dataBoteto, LocalDate dataVencimento) {
        this.valorBoleto = valorBoleto;
        this.dataBoteto = dataBoteto;
        this.dataVencimentoBoleto = dataVencimento;
    }

    /**
     * getters
     * @return
     */
    public String getValorBoleto() {
        return valorBoleto;
    }

    public LocalDate getDataBoteto() {
        return dataBoteto;
    }

    public LocalDate getDataVencimentoBoleto() {
        return dataVencimentoBoleto;
    }
}
