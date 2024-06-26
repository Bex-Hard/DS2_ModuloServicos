package org.jala.moduloservico.controller;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import org.jala.moduloservico.model.Model;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador para o menu do cliente
 */
public class MenuClienteController implements Initializable {

    public BorderPane menu_principal;

    /**
     * Inicializa o menu do cliente.
     *
     * @param url o URL utilizado para resolver caminhos relativos para o objeto raiz ou null se o local não é conhecido.
     * @param resourceBundle o ResourceBundle para localizar objetos raiz ou null se o recurso não é especificado.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory()
                .getSelecionarOpcaoCliente()
                .addListener((observableValue, valorAntigo, valorNovo) ->{
                    switch (valorNovo){
                        case "Transferencia" -> menu_principal.setCenter(Model.getInstance().getViewFactory().getTransferenciaView());
                        case "Cartoes" -> menu_principal.setCenter(Model.getInstance().getViewFactory().getCartoesView());
                        case "Emprestimo" -> menu_principal.setCenter(Model.getInstance().getViewFactory().getEmprestimoView());
                        case "Conta" -> menu_principal.setCenter(Model.getInstance().getViewFactory().getContaView());
                        case "Boleto" -> menu_principal.setCenter(Model.getInstance().getViewFactory().getPagarBoletoView());
                        case "Historico" -> menu_principal.setCenter(Model.getInstance().getViewFactory().getHistoricoServicoView());
                        case "ConfirmaBoleto" -> menu_principal.setCenter(Model.getInstance().getViewFactory().getConfirmaPagarBoletoView());
                        case "Celular" -> menu_principal.setCenter((Model.getInstance().getViewFactory().getRecargaCelularView()));
                        case "Senha" -> Model.getInstance().getViewFactory().solicitarSenha();
                        case "Transporte" -> menu_principal.setCenter(Model.getInstance().getViewFactory().getCartaoTransporte());

                        default -> menu_principal.setCenter(Model.getInstance().getViewFactory().getMenuServicosView());
                    }
                });

    }
}
