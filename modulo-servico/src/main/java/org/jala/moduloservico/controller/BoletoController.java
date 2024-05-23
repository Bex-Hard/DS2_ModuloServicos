package org.jala.moduloservico.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.TextFlow;
import org.jala.moduloservico.controller.service.BoletoService;
import org.jala.moduloservico.model.DTO.BoletoDTO;
import org.jala.moduloservico.model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class BoletoController implements Initializable {
    @FXML
    public TextFlow dados_boleto;
    @FXML
    public Button gerar_boleto;
    @FXML
    public ChoiceBox<String> forma_pagmento;
    @FXML
    public PasswordField senha_conta;
    @FXML
    public TextField valor_boleto;
    @FXML
    public CheckBox data_emissao_boleto_hoje;
    @FXML
    public DatePicker data_boleto;
    @FXML
    public DatePicker data_vencimento;



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
                data_boleto.getValue();
                data_vencimento.getValue();


                BoletoDTO boletoDTO = new BoletoDTO(valor_boleto.getText());
                boletoService = new BoletoService();
                boletoService.gerarBoleto(boletoDTO);

            }
            else {
                Model.getInstance().getViewFactory().atualizarOpcao("ConfirmaBoleto");

            }



        });
    }



    private boolean validarCamposBoleto(){
        try {
            int valorBoletoInt = Integer.parseInt(valor_boleto.getText());
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }

    }
}
