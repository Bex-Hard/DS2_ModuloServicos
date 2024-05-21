package org.jala.moduloservico.controller;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.jala.moduloservico.model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuEsquerdoController implements Initializable {
    public Button conta_botao;
    public Button sair_botao;
    public Button servicos_botao;
    public Button cartoes_botao;
    public Button tranferencias_botao;
    public Button emprestimos_botao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners(){
        tranferencias_botao.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Transferencia"));
        servicos_botao.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Servicos"));
        cartoes_botao.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Cartoes"));
        emprestimos_botao.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Emprestimo"));
        conta_botao.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Conta"));
    }




}
