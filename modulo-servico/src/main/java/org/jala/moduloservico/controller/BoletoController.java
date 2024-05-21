package org.jala.moduloservico.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.TextFlow;
import org.jala.moduloservico.model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class BoletoController implements Initializable {



    public TextField codigo_boleto;
    public TextFlow dados_boleto;
    public Button gerar_boleto;
    public DatePicker data_vencimento;
    @FXML
    public ChoiceBox<String> forma_pagmento;

    public PasswordField senha_conta;

    private final String[] metodosPgamento = {"Saldo Conta Corrente","Cartão de Debito","Cartão de Crédito"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    private void addListeners(){
        forma_pagmento.getItems().addAll(metodosPgamento);
        gerar_boleto.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("ConfirmaBoleto"));
    }
}
