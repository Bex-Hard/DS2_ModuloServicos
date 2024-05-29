package org.jala.moduloservico.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.jala.moduloservico.model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class RecargaCelularController implements Initializable {
    public TextField celular_cliente;
    public Text erro_valid_celular;
    public ChoiceBox operadoras_list;
    public ChoiceBox valor_recarga;
    public ChoiceBox forma_pagamento;
    public Button confirmar_pagamento;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirmar_pagamento.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Senha"));



    }
}
