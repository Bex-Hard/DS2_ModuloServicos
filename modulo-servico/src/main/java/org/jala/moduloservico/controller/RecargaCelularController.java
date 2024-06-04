package org.jala.moduloservico.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.jala.moduloservico.controller.service.TransacaoService;
import org.jala.moduloservico.model.DTO.TransacaoDTO;
import org.jala.moduloservico.model.Pagamento.FabricaPagamento;
import org.jala.moduloservico.model.enums.TipoPagamento;
import org.jala.moduloservico.util.SenhaUtil;
import org.jala.moduloservico.util.ValidacaoInputUsuario;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static org.jala.moduloservico.model.enums.TipoServicos.RECARGA_CELULAR;

/**
 * Controlador para a tela de recarga de celular.
 */
public class RecargaCelularController implements Initializable {
    public TextField celular_cliente;
    public ChoiceBox operadoras_list;
    public ChoiceBox valor_recarga;
    public ChoiceBox forma_pagamento;
    public Button confirmar_pagamento;
    private final String [] metodosPgamento = {"Débito em Conta","Cartão de Crédito"};
    private final String [] operadoras = {"Tim", "Claro", "Vivo","Oi"};
    private final String [] valores = {"R$ 10","R$ 20","R$ 30","R$ 40","R$ 50","R$ 60"};

    /**
     * Inicializa a tela de recarga de celular.
     *
     * @param url o URL utilizado para resolver caminhos relativos para o objeto raiz ou null se o local não é conhecido.
     * @param resourceBundle o ResourceBundle para localizar objetos raiz ou null se o recurso não é especificado.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirmar_pagamento.setOnAction(event -> solicitarConfirmacaoSenha());
        forma_pagamento.getItems().addAll(metodosPgamento);
        operadoras_list.getItems().addAll(operadoras);
        valor_recarga.getItems().addAll(valores);
        ValidacaoInputUsuario.addPhoneValidation(celular_cliente);

    }

    /**
     * Realiza a transação de recarga.
     *
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */

    private void realizarTransacao() throws SQLException {
        TransacaoDTO transacaoDTO = infoTransacao();
        FabricaPagamento fabricaPagamento = new FabricaPagamento();
        TransacaoService transacaoService = new TransacaoService(
                fabricaPagamento,
                fabricaPagamento.getClienteDAO(),
                transacaoDTO);
        transacaoService.realizarTransacao();
    }

    /**
     * Obtém as informações da transação de recarga.
     *
     * @return o objeto TransacaoDTO com as informações da transação.
     */
    private TransacaoDTO infoTransacao() {
        TransacaoDTO transacaoDTO = new TransacaoDTO();
        transacaoDTO.setTipoServicos(RECARGA_CELULAR);
        transacaoDTO.setTipoPagamento(setTipoPagamento());
        transacaoDTO.setValor(setValorRecarga());
        transacaoDTO.setDescricao("Recarga celular");
        return transacaoDTO;
    }

    /**
     * Obtém o valor da recarga selecionado pelo usuário.
     *
     * @return o valor da recarga.
     */
    private String setValorRecarga(){
        String[] valor = valor_recarga.getValue().toString().split(" ");
       return valor[1];
    }
    /**
     * Obtém o tipo de pagamento selecionado pelo usuário.
     *
     * @return o tipo de pagamento.
     */
    private TipoPagamento setTipoPagamento() {
        switch (forma_pagamento.getValue().toString()) {
            case "Débito em Conta" -> {
                return TipoPagamento.DEBITO_CONTA;
            }
            case "Cartão de Crédito" -> {
                return TipoPagamento.CARTAO_CREDITO;
            }
            default -> {
                return null;
            }
        }
    }

    /**
     * Solicita a confirmação da senha antes de realizar a transação.
     */
    private void solicitarConfirmacaoSenha() {
        SenhaUtil.solicitarSenha(senhaCorreta -> {
            if (senhaCorreta) {
                try {
                    realizarTransacao();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
