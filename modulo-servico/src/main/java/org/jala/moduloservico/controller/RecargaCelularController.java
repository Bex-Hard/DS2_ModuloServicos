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
    private final String [] metodosPgamento = {"Cartão de Débito","Cartão de Crédito","PIX"};
    private final String [] operadoras = {"Tim", "Claro", "Vivo","Oi"};
    private final String [] valores = {"R$ 5","R$ 10","R$ 15","R$ 20","R$ 50"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirmar_pagamento.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Senha"));
        forma_pagamento.getItems().addAll(metodosPgamento);
        operadoras_list.getItems().addAll(operadoras);
        valor_recarga.getItems().addAll(valores);

    }
}
