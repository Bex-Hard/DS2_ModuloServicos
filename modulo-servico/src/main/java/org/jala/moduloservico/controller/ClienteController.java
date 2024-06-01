package org.jala.moduloservico.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.ContaCorrente;

import java.net.URL;
import java.util.ResourceBundle;

import static javax.xml.bind.DatatypeConverter.parseString;

public class ClienteController implements Initializable {

    @FXML
    public Label saldo_cliente;
    @FXML
    public Label nome_cliente;
    @FXML
    public Label email_cliente;
    @FXML
    public Label agencia_cliente;
    @FXML
    public Label conta_cliente;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void mostrarDados(Cliente cliente, ContaCorrente contaCorrente){
        saldo_cliente.setText(contaCorrente.getSaldo());
        nome_cliente.setText(cliente.getNome());
        email_cliente.setText(cliente.getEmail());
        agencia_cliente.setText(contaCorrente.getNumeroAgencia());
        conta_cliente.setText(contaCorrente.getNumeroConta());
    }
}
