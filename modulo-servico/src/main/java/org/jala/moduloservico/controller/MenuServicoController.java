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
    public ListView lista_historico;
    public Button bilhete_botao;
    public Button telefone_botao;
    public Button boleto_botao;
    public Button historico_servico;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();


    }
    private void addListeners(){
        boleto_botao.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Boleto"));
        historico_servico.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Historico"));


    }

}
