package org.jala.moduloservico.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import org.jala.moduloservico.controller.ClienteController;
import org.jala.moduloservico.controller.MenuEsquerdoController;


public class ViewFactory {

    private final StringProperty selecionarServico;

    private AnchorPane menuServicosView;
    private AnchorPane pagarBoletoView;
    private AnchorPane contaView;
    private AnchorPane emprestimoView;
    private AnchorPane cartoesView;
    private AnchorPane TransferenciaView;

    public StringProperty getSelecionarServico() {
        return selecionarServico;
    }

    public ViewFactory( ) {
        this.selecionarServico = new SimpleStringProperty("");
    }

    public AnchorPane getPagarBoletoView(){
        if (pagarBoletoView == null){
            try {
                pagarBoletoView = new FXMLLoader(getClass().getResource("/Fxml/PagarBoleto")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return pagarBoletoView;
    }


    public AnchorPane getMenuServicosView(){
        if (menuServicosView == null){
            try {
                menuServicosView = new FXMLLoader(getClass().getResource("/Fxml/MenuServicos")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return menuServicosView;
    }

    public void mostrarClienteMenu(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/MenuCliente.fxml"));
        MenuEsquerdoController menuEsquerdoController = new MenuEsquerdoController();
        loader.setController(menuEsquerdoController);
        criarStage(loader);
    }

    public void mostrarServicoBoleto(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/PagarBoleto.fxml"));
        ClienteController clienteController = new ClienteController();
        loader.setController(clienteController);
        criarStage(loader);
    }






    private static void criarStage(FXMLLoader loader) {
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("JalaBank");
        stage.show();
    }



}
