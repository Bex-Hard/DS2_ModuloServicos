package org.jala.moduloservico.model.DTO;

import java.time.LocalDate;

public class BoletoDTO {
    private String valorBoleto;
    private LocalDate dataBoteto;
    private LocalDate dataVencimentoBoleto;


    public BoletoDTO(String valorBoleto, LocalDate dataBoteto, LocalDate dataVencimento) {
        this.valorBoleto = valorBoleto;
        this.dataBoteto = dataBoteto;
        this.dataVencimentoBoleto = dataVencimento;
    }

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
