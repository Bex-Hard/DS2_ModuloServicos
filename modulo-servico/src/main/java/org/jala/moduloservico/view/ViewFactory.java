package org.jala.moduloservico.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import org.jala.moduloservico.controller.MenuClienteController;
import org.jala.moduloservico.model.Model;


public class ViewFactory {

    private final StringProperty selecionarOpcaoCliente;

    private AnchorPane menuServicosView;
    private AnchorPane transferenciaView;
    private AnchorPane contaView;
    private AnchorPane emprestimoView;
    private AnchorPane cartoesView;
    private AnchorPane pagarBoletoView;
    private AnchorPane confirmarBoletoView;
    private AnchorPane historicoServicoView;
    private AnchorPane recargaCelularView;
    private GridPane solicitarSenha;
    private AnchorPane viewHistoricoServico;

    public GridPane getSolicitarSenha() {
        if (solicitarSenha == null){
            try{
                solicitarSenha = new FXMLLoader(getClass().getResource("/Fxml/Popup/SolicitarSenha.fxml")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return solicitarSenha;
    }

    public ViewFactory( ) {
        this.selecionarOpcaoCliente = new SimpleStringProperty("");
    }

    public StringProperty getSelecionarOpcaoCliente() {
        return selecionarOpcaoCliente;
    }

    //Menu Esquerdo de Opções do Cliente

    public AnchorPane getViewHistoricoServico(){
        if (viewHistoricoServico == null) {
            try {
                viewHistoricoServico = new FXMLLoader(getClass().getResource("/Fxml/HistoricoTransacaoServicos/ViewHistoricoServico.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return viewHistoricoServico;
    }
    public AnchorPane getContaView(){
            try {
                contaView = new FXMLLoader(getClass().getResource("/Fxml/OutrosServicos/Conta.fxml")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        return contaView;
    }

    public AnchorPane getCartoesView(){
        if(cartoesView == null) {
            try {
                cartoesView = new FXMLLoader(getClass().getResource("/Fxml/OutrosServicos/MeusCartoes.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cartoesView;
    }

    public AnchorPane getEmprestimoView(){
        if (emprestimoView == null){
            try {
                emprestimoView = new FXMLLoader(getClass().getResource("/Fxml/OutrosServicos/Emprestimos.fxml")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return emprestimoView;
    }

    public AnchorPane getMenuServicosView(){
        if (menuServicosView == null){
            try {
                menuServicosView = new FXMLLoader(getClass().getResource("/Fxml/MenuServicos.fxml")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return menuServicosView;
    }

    public AnchorPane getTransferenciaView() {
        if (transferenciaView == null){
            try {
                transferenciaView = new FXMLLoader(getClass().getResource("/Fxml/OutrosServicos/Transferencias.fxml")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }


        return transferenciaView;
    }

    //Pagamento de boleto

    public AnchorPane getPagarBoletoView(){
if (pagarBoletoView == null){
            try {
                pagarBoletoView = new FXMLLoader(getClass().getResource("/Fxml/Boleto/PagarBoleto.fxml")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
}
        return pagarBoletoView;
    }
    public AnchorPane getConfirmaPagarBoletoView(){
        if (confirmarBoletoView == null){
            try {
                confirmarBoletoView = new FXMLLoader(getClass().getResource("/Fxml/Boleto/FinalizaBoleto.fxml")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return confirmarBoletoView;
    }

    //Historico Servico
    public AnchorPane getHistoricoServicoView(){
            try {
                historicoServicoView = new FXMLLoader(getClass().getResource("/Fxml/HistoricoTransacaoServicos/HistoricoServico.fxml")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        return historicoServicoView;
    }

    //Recarga Celular


    public AnchorPane getRecargaCelularView() {
            try{
                recargaCelularView = new FXMLLoader(getClass().getResource("/Fxml/Celular/Recarga.fxml")).load();
            }catch (Exception e) {
                e.printStackTrace();
            }
        return recargaCelularView;
    }
    public void solicitarSenha(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Popup/SolicitarSenha.fxml"));
//        MenuClienteController menuClienteController = new MenuClienteController();
//        loader.setController(menuClienteController);
        criarStage(loader);
    }


    public void mostrarClienteMenu(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/MenuCliente.fxml"));
        MenuClienteController menuClienteController = new MenuClienteController();
        loader.setController(menuClienteController);
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




    public void atualizarOpcao(String botaoOpcao){
        Model.getInstance().getViewFactory().getSelecionarOpcaoCliente().set(botaoOpcao);

    }



}
