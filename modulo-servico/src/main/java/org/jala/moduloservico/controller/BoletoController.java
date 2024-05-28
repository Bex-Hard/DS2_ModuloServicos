package org.jala.moduloservico.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import org.jala.moduloservico.controller.service.BoletoService;
import org.jala.moduloservico.model.DTO.BoletoDTO;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BoletoController implements Initializable {

    @FXML
    public Button gerar_boleto;
    @FXML
    public ChoiceBox<String> forma_pagmento;
    @FXML
    public TextField valor_boleto;
    @FXML
    public DatePicker data_boleto;
    @FXML
    public DatePicker data_vencimento_vencimento;
    @FXML
    public Text erro_campos;

    private final String[] metodosPgamento = {"Conta Corrente","Conta Poupança","Cartão de Crédito"};


    private BoletoService boletoService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        forma_pagmento.getItems().addAll(metodosPgamento);
        addListeners();

    }
    private void addListeners(){
        gerar_boleto.setOnAction(event -> {
            if (validarCamposBoleto()) {
                erro_campos.setVisible(false);
                LocalDate dataBoletoLocalDate = tranformaLocalDate(data_boleto);
                LocalDate dataBoletoVencimentoLocalDate = tranformaLocalDate(data_vencimento_vencimento);

                BoletoDTO boletoDTO = new BoletoDTO(
                        valor_boleto.getText(),
                        dataBoletoLocalDate,
                        dataBoletoVencimentoLocalDate);


                boletoService = new BoletoService();
                boletoService.gerarBoleto(boletoDTO);
                boletoService.gerarPDFBoleto();

                mostrarBoletoGerado(boletoService);

            }
            else {
                erro_campos.setVisible(true);
            }
        });
    }
    private boolean validarCamposBoleto(){
        try {
            int valorBoletoInt = Integer.parseInt(valor_boleto.getText());
        }
        catch (NumberFormatException e){
            return false;
        }
        return data_boleto.getValue() != null && data_vencimento_vencimento.getValue() != null;

    }

    private void mostrarBoletoGerado(BoletoService boletoService){
    }

    private LocalDate tranformaLocalDate(DatePicker escolhaData){
        return escolhaData.getValue();
    }

}
