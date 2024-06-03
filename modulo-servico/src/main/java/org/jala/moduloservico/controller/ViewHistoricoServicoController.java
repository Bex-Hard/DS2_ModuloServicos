package org.jala.moduloservico.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.jala.moduloservico.model.DAO.HistoricoTransacaoDAO;
import org.jala.moduloservico.model.Transacao;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewHistoricoServicoController implements Initializable {

    @FXML
    public TableView<Transacao> lista_transacao;
    @FXML
    public TableColumn<Transacao, String> tipo_pagamento;
    @FXML
    public TableColumn<Transacao, Double> valor_transacao;
    @FXML
    public TableColumn<Transacao, String> conta_destino;
    @FXML
    public TableColumn<Transacao, Boolean> status;
    @FXML
    public TableColumn<Transacao, String> id_transacao;
    @FXML
    public TableColumn<Transacao, String> data;

    private HistoricoTransacaoDAO historicoTransacaoDAO;
    private ObservableList<Transacao> transacaoList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        historicoTransacaoDAO = new HistoricoTransacaoDAO();
        transacaoList = FXCollections.observableArrayList();

        carregarTabela();
        atualizarTransacoes(1L);
    }

    private void carregarTabela() {
        tipo_pagamento.setCellValueFactory(new PropertyValueFactory<>("tipoPagamento"));
        valor_transacao.setCellValueFactory(new PropertyValueFactory<>("valor"));
        conta_destino.setCellValueFactory(new PropertyValueFactory<>("contaDestino"));
        status.setCellValueFactory(new PropertyValueFactory<>("confirmacao"));
    }

    private void atualizarTransacoes(Long idUser) {
        try {
            List<Transacao> transacoes = historicoTransacaoDAO.listarTransacoesPorCliente(idUser);
            transacaoList.clear();
            transacaoList.addAll(transacoes);
            lista_transacao.setItems(transacaoList);
        } catch (SQLException e) {
            Logger.getLogger(ViewHistoricoServicoController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
