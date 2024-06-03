package org.jala.moduloservico.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.jala.moduloservico.controller.ConfirmarPagamentoController;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import org.jala.moduloservico.model.Pagamento.FabricaPagamento;


public class SenhaUtil {

    public static void solicitarSenha(SenhaVerificacaoListener listener) {
        try {
            FXMLLoader loader = new FXMLLoader(SenhaUtil.class.getResource("/Fxml/Popup/SolicitarSenha.fxml"));
            Parent root = loader.load();

            ConfirmarPagamentoController confirmarPagamentoController = loader.getController();
            FabricaPagamento fabricaPagamento = new FabricaPagamento();
            confirmarPagamentoController.setSenhaVerificacaoListener(listener, fabricaPagamento.getCliente().getSenha());

            Stage stage = new Stage();
            stage.setTitle("Confirmar Pagamento");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}