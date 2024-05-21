package org.jala.moduloservico.controller;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import org.jala.moduloservico.model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuClienteController implements Initializable {

    public BorderPane menu_principal;

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

                        case "ConfirmaBoleto" -> menu_principal.setCenter(Model.getInstance().getViewFactory().getConfirmaPagarBoletoView());



                        default -> menu_principal.setCenter(Model.getInstance().getViewFactory().getMenuServicosView());
                    }
                        }
                        );

    }
}
