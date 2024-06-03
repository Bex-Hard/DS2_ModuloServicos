package org.jala.moduloservico.controller;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.jala.moduloservico.model.Model;

import java.net.URL;
import java.util.ResourceBundle;
/**
 * Controlador para a tela de menu esquerdo.
 */
public class MenuEsquerdoController implements Initializable {
    public Button conta_botao;
    public Button sair_botao;
    public Button servicos_botao;
    public Button cartoes_botao;
    public Button tranferencias_botao;
    public Button emprestimos_botao;

    /**
     * Inicializa a tela de menu de serviços.
     *
     * @param url o URL utilizado para resolver caminhos relativos para o objeto raiz ou null se o local não é conhecido.
     * @param resourceBundle o ResourceBundle para localizar objetos raiz ou null se o recurso não é especificado.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    /**
     * Adiciona os ouvintes de eventos aos botões.
     */
    private void addListeners(){
        tranferencias_botao.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Transferencia"));
        servicos_botao.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Servicos"));
        cartoes_botao.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Cartoes"));
        emprestimos_botao.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Emprestimo"));
        conta_botao.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Conta"));
        sair_botao.setOnAction(event -> Platform.exit());
    }




}
