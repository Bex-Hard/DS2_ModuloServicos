package org.jala.moduloservico.model.DTO;

import java.time.LocalDate;

public class BoletoDTO {
    private String valorBoleto;
    private LocalDate dataBoteto;
    private LocalDate dataVencimento;



    public BoletoDTO(String valorBoleto) {
        this.valorBoleto = valorBoleto;
    }

    public String getValorBoleto() {
        return valorBoleto;
    }
}
