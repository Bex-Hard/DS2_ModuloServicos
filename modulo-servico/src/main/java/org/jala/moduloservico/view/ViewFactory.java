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

/**
 * Classe responsável por criar e gerenciar as diferentes views da aplicação.
 */
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


    /**
     * Construtor da classe ViewFactory.
     */
    public ViewFactory( ) {
        this.selecionarOpcaoCliente = new SimpleStringProperty("");
    }


    /**
     * Retorna a propriedade selecionarOpcaoCliente.
     *
     * @return A StringProperty selecionarOpcaoCliente.
     */

    public StringProperty getSelecionarOpcaoCliente() {
        return selecionarOpcaoCliente;
    }

    /**
     * Retorna a view do histórico de serviços.  (Menu Esquerdo)
     * @return A AnchorPane do histórico de serviços.
     */
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
    /**
     * Retorna a view da conta.
     *
     * @return A AnchorPane da conta.
     */
    public AnchorPane getContaView(){
            try {
                contaView = new FXMLLoader(getClass().getResource("/Fxml/OutrosServicos/Conta.fxml")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        return contaView;
    }
    /**
     * Retorna a view dos cartões.
     *
     * @return A AnchorPane dos cartões.
     */
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
    /**
     * Retorna a view dos empréstimos.
     *
     * @return A AnchorPane dos empréstimos.
     */
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
    /**
     * Retorna a view do menu de serviços.
     *
     * @return A AnchorPane do menu de serviços.
     */
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
    /**
     * Retorna a view de transferências.
     *
     * @return A AnchorPane de transferências.
     */
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

    /**
     * Retorna a view de pagamento de boleto.
     *
     * @return A AnchorPane de pagamento de boleto.
     */

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
    /**
     * Retorna a view de confirmação de pagamento de boleto.
     *
     * @return A AnchorPane de confirmação de pagamento de boleto.
     */
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

    /**
     * Retorna a view do histórico de serviços.
     *
     * @return A AnchorPane do histórico de serviços.
     */
    public AnchorPane getHistoricoServicoView(){
            try {
                historicoServicoView = new FXMLLoader(getClass().getResource("/Fxml/HistoricoTransacaoServicos/HistoricoServico.fxml")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        return historicoServicoView;
    }

    /**
     * Retorna a view de recarga de celular.
     *
     * @return A AnchorPane de recarga de celular.
     */
    public AnchorPane getRecargaCelularView() {
            try{
                recargaCelularView = new FXMLLoader(getClass().getResource("/Fxml/Celular/Recarga.fxml")).load();
            }catch (Exception e) {
                e.printStackTrace();
            }
        return recargaCelularView;
    }
    /**
     * Solicita a senha, exibindo o popup correspondente.
     */
    public void solicitarSenha(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Popup/SolicitarSenha.fxml"));
        criarStage(loader);
    }
    /**
     * Exibe o menu do cliente.
     */
    public void mostrarClienteMenu(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/MenuCliente.fxml"));
        MenuClienteController menuClienteController = new MenuClienteController();
        loader.setController(menuClienteController);
        criarStage(loader);
    }
    /**
     * Cria e exibe uma nova janela (Stage) a partir do loader fornecido.
     *
     * @param loader O FXMLLoader a ser utilizado para carregar o layout.
     */
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

    /**
     * Atualiza a opção selecionada do cliente.
     *
     * @param botaoOpcao A nova opção selecionada.
     */
    public void atualizarOpcao(String botaoOpcao){
        Model.getInstance().getViewFactory().getSelecionarOpcaoCliente().set(botaoOpcao);

    }



}
