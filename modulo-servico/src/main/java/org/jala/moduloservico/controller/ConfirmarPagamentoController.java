package org.jala.moduloservico.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jala.moduloservico.util.SenhaVerificacaoListener;

import java.net.URL;
import java.util.ResourceBundle;
/**
 * Controlador para confirmar o pagamento.
 */
public class ConfirmarPagamentoController implements Initializable {
    @FXML
    public Label msg_erro;
    @FXML
    public Button confirmar;
    @FXML
    public TextField senha_usuario;
    @FXML
    public VBox solicitar_senha;
    @FXML
    public VBox sucesso_transacao;
    @FXML
    public VBox saldo_insuficiente;

    private SenhaVerificacaoListener listener;
    private String senhaClienteBD;
    private Stage stage; // Adicionar referência ao Stage


    /**
     * Inicializa o controlador.
     *
     * @param url            o URL utilizado para resolver caminhos relativos para o objeto raiz ou null se o local não é conhecido.
     * @param resourceBundle o ResourceBundle para localizar objetos raiz ou null se o recurso não é especificado.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirmar.setOnAction(event -> verificarSenha());

    }
    /**
     * Define o ouvinte para verificação da senha e a senha do cliente.
     *
     * @param listener       o ouvinte para verificação da senha.
     * @param senhaClienteBD a senha do cliente armazenada no banco de dados.
     */
    public void setSenhaVerificacaoListener(SenhaVerificacaoListener listener, String senhaClienteBD) {
        this.listener = listener;
        this.senhaClienteBD = senhaClienteBD;
    }
    /**
     * Verifica se a senha inserida é correta.
     */
    private void verificarSenha() {
        boolean senhaCorreta = senhaClienteBD.equals(senha_usuario.getText());

        if (listener != null) {
            listener.onSenhaVerificada(senhaCorreta);
            solicitar_senha.setVisible(false);
            sucesso_transacao.setVisible(true);
            if (senhaCorreta && stage != null) {
                stage.close(); // Fechar o Stage se a senha estiver correta
            }
        }

        if (!senhaCorreta) {
            msg_erro.setText("Senha incorreta. Tente novamente.");
        }
    }

    public void saldoInsuficiente() {
        solicitar_senha.setVisible(false);
        sucesso_transacao.setVisible(false);
        saldo_insuficiente.setVisible(true);
        if (stage != null) {
            stage.close();
        }
    }


    public void setStage(Stage stage) { // Método para definir o Stage
        this.stage = stage;
    }
}
