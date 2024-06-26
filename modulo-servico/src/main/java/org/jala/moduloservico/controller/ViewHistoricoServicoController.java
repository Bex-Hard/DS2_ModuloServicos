package org.jala.moduloservico.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.jala.moduloservico.model.DAO.HistoricoTransacaoDAO;
import org.jala.moduloservico.model.Transacao;
import org.jala.moduloservico.util.StartCliente;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador para a visualização do histórico de serviços.
 */
public class ViewHistoricoServicoController implements Initializable {

    @FXML
    public TableView<Transacao> lista_transacao;
    @FXML
    public TableColumn<Transacao, String> tipo_pagamento;
    @FXML
    public TableColumn<Transacao, Double> valor_transacao;
    @FXML
    public TableColumn<Transacao, Boolean> status;
    @FXML
    public TableColumn<Transacao, String> id_transacao;
    @FXML
    public TableColumn<Transacao, String> data;
    @FXML
    public TableColumn<Transacao, String> tipo_servico;

    private HistoricoTransacaoDAO historicoTransacaoDAO;
    private ObservableList<Transacao> transacaoList;

    /**
     * Inicializa o controlador.
     *
     * @param url o URL utilizado para resolver caminhos relativos para o objeto raiz ou null se o local não é conhecido.
     * @param resourceBundle o ResourceBundle para localizar objetos raiz ou null se o recurso não é especificado.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        historicoTransacaoDAO = new HistoricoTransacaoDAO();
        transacaoList = FXCollections.observableArrayList();

        carregarTabela();
        atualizarTransacoes(StartCliente.getInstance().getCliente().getId());
    }
    /**
     * Configura as colunas da tabela para exibir as propriedades das transações.
     */
    private void carregarTabela() {
        tipo_pagamento.setCellValueFactory(new PropertyValueFactory<>("tipoPagamento"));
        valor_transacao.setCellValueFactory(new PropertyValueFactory<>("valor"));
        status.setCellValueFactory(new PropertyValueFactory<>("confirmacao"));
        id_transacao.setCellValueFactory(new PropertyValueFactory<>("idTransacao"));
        tipo_servico.setCellValueFactory(new PropertyValueFactory<>("tipoServico"));
        data.setCellValueFactory(new PropertyValueFactory<>("dataHoraTransacao"));

    }
    /**
     * Atualiza a lista de transações para o cliente especificado.
     *
     * @param idUser o ID do cliente cujas transações devem ser listadas.
     */
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
