package org.jala.moduloservico.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.jala.moduloservico.util.SenhaVerificacaoListener;

import java.net.URL;
import java.util.ResourceBundle;

public class ConfirmarPagamentoController implements Initializable {
    public Label msg_erro;
    public Button confirmar;
    public TextField senha_usuario;
    public VBox solicitar_senha;
    public VBox sucesso_transacao;
    private SenhaVerificacaoListener listener;
    private String senhaClienteBD;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirmar.setOnAction(event -> verificarSenha());

    }
    public void setSenhaVerificacaoListener(SenhaVerificacaoListener listener, String senhaClienteBD) {
        this.listener = listener;
        this.senhaClienteBD = senhaClienteBD;
    }



    private void verificarSenha() {
        boolean senhaCorreta = senhaClienteBD.equals(senha_usuario.getText());

        if (listener != null) {
            listener.onSenhaVerificada(senhaCorreta);
            solicitar_senha.setVisible(false);
            sucesso_transacao.setVisible(true);

        }

        if (!senhaCorreta) {
            msg_erro.setText("Senha incorreta. Tente novamente.");
        }
    }

}
