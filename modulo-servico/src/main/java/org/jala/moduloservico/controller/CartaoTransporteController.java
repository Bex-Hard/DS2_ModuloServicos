package org.jala.moduloservico.controller;

import javafx.fxml.FXML;
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

import static org.jala.moduloservico.model.enums.TipoServicos.CARTAO_TRANSPORTE;

public class CartaoTransporteController implements Initializable {
    @FXML
    public TextField numero_cartao;
    @FXML
    public ChoiceBox forma_pagamento;
    @FXML
    public ChoiceBox valor_recarga;
    @FXML
    public Button recarregar;

    private final String[] metodosPagamento = {"Débito em Conta", "Cartão de Crédito"};
    private final String[] valores = {"R$ 10", "R$ 20", "R$ 30", "R$ 40", "R$ 50", "R$ 60", "R$ 100"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recarregar.setOnAction(event -> solicitarConfirmacaoSenha());
        forma_pagamento.getItems().addAll(metodosPagamento);
        valor_recarga.getItems().addAll(valores);
        ValidacaoInputUsuario.addCardValidation(numero_cartao);
    }
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
     * Obtém o valor da recarga selecionado pelo usuário.
     *
     * @return o valor da recarga.
     */
    private String setValorRecarga () {
        String[] valor = valor_recarga.getValue().toString().split(" ");
        return valor[1];
    }

    /**
     * Obtém as informações da transação de recarga.
     *
     * @return o objeto TransacaoDTO com as informações da transação.
     */
    private TransacaoDTO infoTransacao() {
        TransacaoDTO transacaoDTO = new TransacaoDTO();
        transacaoDTO.setTipoServicos(CARTAO_TRANSPORTE);
        transacaoDTO.setTipoPagamento(setTipoPagamento());
        transacaoDTO.setValor(setValorRecarga());
        transacaoDTO.setDescricao("Recarga Cartao Transporte");
        return transacaoDTO;
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
