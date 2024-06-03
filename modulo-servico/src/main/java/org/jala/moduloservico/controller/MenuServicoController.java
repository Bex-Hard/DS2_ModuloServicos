package org.jala.moduloservico.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import org.jala.moduloservico.model.Model;

import java.net.URL;
import java.util.ResourceBundle;
/**
 * Controlador para a tela de menu de serviços.
 */
public class MenuServicoController implements Initializable {
    public Label data_login;
    public Text nome_cliente;
    public ListView lista_historico;
    public Button bilhete_botao;
    public Button celular_botao;
    public Button boleto_botao;
    public Button historico_servico;

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
        boleto_botao.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Boleto"));
        historico_servico.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Historico"));
        celular_botao.setOnAction(event -> Model.getInstance().getViewFactory().atualizarOpcao("Celular"));


    }

}
