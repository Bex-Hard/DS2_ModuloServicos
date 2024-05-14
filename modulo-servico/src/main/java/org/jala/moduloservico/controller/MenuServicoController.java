package org.jala.moduloservico.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import org.jala.moduloservico.model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuServicoController implements Initializable {
    public Label data_login;
    public Text nome_cliente;
    public Button servico_boleto;
    public Button servico_telefone;
    public Button servico_bilhete_transporte;
    public ListView lista_historico;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
