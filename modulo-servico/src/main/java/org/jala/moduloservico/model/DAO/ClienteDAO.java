package org.jala.moduloservico.model.DAO;
import org.jala.moduloservico.model.CartaoCredito;
import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.ContaCorrente;
import org.jala.moduloservico.model.ContaPoupanca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.jala.moduloservico.model.DAO.PostgresConnection.getConnection;

public class ClienteDAO {


    public Cliente buscarClientePorId(Long id) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getLong("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setCep(rs.getString("cep"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setLogradouro(rs.getString("logradouro"));
                    cliente.setBairro(rs.getString("bairro"));
                    cliente.setCidade(rs.getString("cidade"));
                    cliente.setUf(rs.getString("uf"));
                    cliente.setSenha(rs.getString("senha"));
                    // Buscar conta corrente do cliente
                    ContaCorrente contaCorrente = buscarContaCorrentePorClienteId(cliente.getId());
                    cliente.setContaCorrente(contaCorrente);
                    return cliente;
                }
            }
        }
        return null;
    }

    public ContaCorrente buscarContaCorrentePorClienteId(Long clienteId) throws SQLException {
        String sql = "SELECT * FROM conta_corrente WHERE cliente_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, clienteId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ContaCorrente contaCorrente = new ContaCorrente();
                    contaCorrente.setId(rs.getLong("id"));
                    contaCorrente.setNumeroAgencia(rs.getString("numero_agencia"));
                    contaCorrente.setDigitoAgencia(rs.getString("digito_agencia"));
                    contaCorrente.setNumeroConta(rs.getString("numero_conta"));
                    contaCorrente.setSaldo(rs.getDouble("saldo"));
                    // Buscar cartao do conta corrente
                    CartaoCredito cartaoCredito = buscarCartaoCreditoPorContaCorrenteId(contaCorrente.getId());
                    contaCorrente.setCartao(cartaoCredito);
                    return contaCorrente;
                }
            }
        }
        return null;
    }

    public CartaoCredito buscarCartaoCreditoPorContaCorrenteId(Long contaCorrenteId) throws SQLException {
        String sql = "SELECT * FROM cartao_credito WHERE conta_corrente_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, contaCorrenteId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    CartaoCredito cartaoCredito = new CartaoCredito();
                    cartaoCredito.setId(rs.getLong("id"));
                    cartaoCredito.setNumeroCartao(rs.getString("numero_cartao"));
                    cartaoCredito.setValidade(rs.getDate("validade").toLocalDate());
                    cartaoCredito.setCvv(rs.getString("cvv"));
                    cartaoCredito.setLimite(rs.getDouble("limite"));
                    cartaoCredito.setSaldoUtilizado(rs.getDouble("saldo_utilizado"));
                    return cartaoCredito;
                }
            }
        }
        return null;
    }

    public void atualizarSaldoContaCorrente(Long contaCorrenteId, double novoSaldo) throws SQLException {
        String sql = "UPDATE conta_corrente SET saldo = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, novoSaldo);
            stmt.setLong(2, contaCorrenteId);
            stmt.executeUpdate();
        }
    }

    public void atualizarLimiteCartaoCredito(Long cartaoId, double novoLimite) throws SQLException {
        String sql = "UPDATE cartao_credito SET limite = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, novoLimite);
            stmt.setLong(2, cartaoId);
            stmt.executeUpdate();
        }
    }

    public void atualizarSaldoUtilizadoCartaoCredito(Long cartaoId, double novoSaldoUtilizado) throws SQLException {
        String sql = "UPDATE cartao_credito SET saldo_utilizado = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, novoSaldoUtilizado);
            stmt.setLong(2, cartaoId);
            stmt.executeUpdate();
        }
    }
}
//------------------------------------------------------------------------------------
   /** private List<ContaPoupanca> getContasPoupancaByClienteId(int clienteId, Connection connection) {
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
} **/