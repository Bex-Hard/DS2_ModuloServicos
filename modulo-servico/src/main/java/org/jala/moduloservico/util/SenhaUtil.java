package org.jala.moduloservico.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.jala.moduloservico.controller.ConfirmarPagamentoController;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import org.jala.moduloservico.model.DTO.TransacaoDTO;
import org.jala.moduloservico.model.Pagamento.FabricaPagamento;

/**
 * Classe utilitária para solicitação de senha.
 */
public class SenhaUtil {

    /**
     * Método estático para solicitar a senha ao usuário.
     * @param listener O Listener de Verificação de Senha.
     */
    public static void solicitarSenha(SenhaVerificacaoListener listener) {
        try {
            FXMLLoader loader = new FXMLLoader(SenhaUtil.class.getResource("/Fxml/Popup/SolicitarSenha.fxml"));
            Parent root = loader.load();

            ConfirmarPagamentoController confirmarPagamentoController = loader.getController();
            FabricaPagamento fabricaPagamento = new FabricaPagamento();
            confirmarPagamentoController.setSenhaVerificacaoListener(listener, fabricaPagamento.getCliente().getSenha());

            Stage stage = new Stage();
            confirmarPagamentoController.setStage(stage); // Passar o Stage para o controlador

            stage.setTitle("Confirmar Pagamento");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Mostra quando a transação acontece/senha é válida, porém o cliente não possui saldo na conta ou cartao
     */
    public static void saldoInsuficiente() {
        try {
            FXMLLoader loader = new FXMLLoader(SenhaUtil.class.getResource("/Fxml/Popup/SolicitarSenha.fxml"));
            Parent root = loader.load();

            ConfirmarPagamentoController confirmarPagamentoController = loader.getController();
            confirmarPagamentoController.saldoInsuficiente();

            Stage stage = new Stage();
            stage.setTitle("Saldo Insuficiente");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}