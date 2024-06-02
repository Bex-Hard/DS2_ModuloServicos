package org.jala.moduloservico.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.DAO.ClienteDAO;
import org.jala.moduloservico.util.StartCliente;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClienteController extends ClienteDAO implements Initializable {


    @FXML
    public Label saldo_cliente;
    @FXML
    public Label nome_cliente;
    @FXML
    public Label email_cliente;
    @FXML
    public Label agencia_cliente;
    @FXML
    public Label conta_cliente;

    public Cliente cliente = StartCliente.getInstance().getCliente();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            mostrarDados();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void mostrarDados() throws SQLException {
        
        saldo_cliente.setText(saldoAtualizado());
        nome_cliente.setText(cliente.getNome());
        email_cliente.setText(cliente.getEmail());
        agencia_cliente.setText(cliente.getContaCorrente().getNumeroAgencia());
        conta_cliente.setText(cliente.getContaCorrente().getNumeroConta());
    }

    private String saldoAtualizado(){
        String saldo = "";
        try {
            saldo = buscarSaldoPorClienteId(cliente.getId());
            if (saldo == null) {
                return "deu erro.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saldo;
    }

}
