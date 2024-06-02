package org.jala.moduloservico.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.jala.moduloservico.model.Transacao;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewHistoricoServicoController implements Initializable {
    @FXML
    public Label valor_transacao;

    @FXML
    public Label data_transacao;

    @FXML
    public Label tipoServico_transacao;

    @FXML
    public Label tipoPagamento_transacao;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void mostraTransacoes (Transacao transacao){
        valor_transacao.setText(String.valueOf(transacao.getValor()));
        tipoPagamento_transacao.setText(String.valueOf(transacao.getTipoPagamento()));
        tipoServico_transacao.setText(String.valueOf(transacao.getTipoServico()));
        data_transacao.setText(String.valueOf(transacao.getDataHoraTransacao()));
    }
}
