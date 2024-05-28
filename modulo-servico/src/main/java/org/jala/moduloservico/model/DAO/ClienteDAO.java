package org.jala.moduloservico.model.DAO;
import org.jala.moduloservico.model.CartaoCredito;
import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.ContaPoupanca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public Cliente getClienteById(int id) {
        Cliente cliente = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = PostgresConnection.getConnection();
            String sql = "SELECT * FROM Cliente WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente();
//                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setLogradouro(resultSet.getString("logradouro"));
                cliente.setBairro(resultSet.getString("bairro"));
                cliente.setCidade(resultSet.getString("cidade"));
                cliente.setUf(resultSet.getString("uf"));

//
//                cliente.setContasPoupanca(getContasPoupancaByClienteId(id, connection));
//                cliente.setCartoesDeCredito(getCartoesCreditoByClienteId(id, connection));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            PostgresConnection.closeConnection(connection);
            closeResources(statement, resultSet);
        }
        return cliente;
    }

    private List<ContaPoupanca> getContasPoupancaByClienteId(int clienteId, Connection connection) {
        List<ContaPoupanca> contasPoupanca = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM ContaPoupanca WHERE cliente_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, clienteId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ContaPoupanca contaPoupanca = new ContaPoupanca();
                contaPoupanca.setNumero(resultSet.getString("numero"));
                contaPoupanca.setSaldo(resultSet.getDouble("saldo"));
                contaPoupanca.setTaxaDeJuros(resultSet.getDouble("taxaDeJuros"));
                contasPoupanca.add(contaPoupanca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(statement, resultSet);
        }
        return contasPoupanca;
    }

    private List<CartaoCredito> getCartoesCreditoByClienteId(int clienteId, Connection connection) {
        List<CartaoCredito> cartoesCredito = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM CartaoCredito WHERE cliente_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, clienteId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CartaoCredito cartaoCredito = new CartaoCredito();
                cartaoCredito.setNumero(resultSet.getString("numero"));
                cartaoCredito.setLimite(resultSet.getDouble("limite"));
                cartaoCredito.setSaldoUtilizado(resultSet.getDouble("saldoUtilizado"));
                cartoesCredito.add(cartaoCredito);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(statement, resultSet);
        }
        return cartoesCredito;
    }

    private void closeResources(Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}