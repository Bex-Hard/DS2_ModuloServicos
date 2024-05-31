package org.jala.moduloservico.controller;

import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.jala.moduloservico.model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class HistoricoController implements Initializable {
    public Button gerar_historico;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gerar_historico.setOnAction(actionEvent -> Model.getInstance().getViewFactory().atualizarOpcao("HistoricoFiltrado"));
    }
}
