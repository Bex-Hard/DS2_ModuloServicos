package org.jala.moduloservico.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.jala.moduloservico.model.Model;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador para o menu do historico
 */
public class HistoricoController implements Initializable {
    public Button gerar_historico;

    /**
     * Inicializa o menu do cliente.
     *
     * @param url o URL utilizado para resolver caminhos relativos para o objeto raiz ou null se o local não é conhecido.
     * @param resourceBundle o ResourceBundle para localizar objetos raiz ou null se o recurso não é especificado.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gerar_historico.setOnAction(actionEvent -> Model.getInstance().getViewFactory().atualizarOpcao("HistoricoFiltrado"));
    }
}
