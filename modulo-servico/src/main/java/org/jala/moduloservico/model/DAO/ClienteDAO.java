package org.jala.moduloservico.model.DAO;
import org.jala.moduloservico.model.CartaoCredito;
import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.ContaCorrente;

import java.sql.*;

import static org.jala.moduloservico.model.DAO.PostgresConnection.getConnection;

/**
 * Classe responsável pelo acesso aos dados dos clientes no banco de dados.
 */
public class ClienteDAO {

    /**
     * Busca um cliente pelo seu ID.
     *
     * @param id o ID do cliente a ser buscado.
     * @return o cliente encontrado, ou null se nenhum cliente for encontrado.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
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
    /**
     * Busca a conta corrente de um cliente pelo ID do cliente.
     *
     * @param clienteId o ID do cliente.
     * @return a conta corrente do cliente, ou null se nenhuma conta for encontrada.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
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
    /**
     * Busca o cartão de crédito de uma conta corrente pelo ID da conta corrente.
     *
     * @param contaCorrenteId o ID da conta corrente.
     * @return o cartão de crédito da conta corrente, ou null se nenhum cartão for encontrado.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
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
    /**
     * Atualiza o saldo de uma conta corrente.
     *
     * @param contaCorrenteId o ID da conta corrente.
     * @param novoSaldo o novo saldo da conta corrente.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public void atualizarSaldoContaCorrente(Long contaCorrenteId, double novoSaldo) throws SQLException {
        String sql = "UPDATE conta_corrente SET saldo = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, novoSaldo);
            stmt.setLong(2, contaCorrenteId);
            stmt.executeUpdate();
        }
    }
    /**
     * Atualiza o limite de um cartão de crédito.
     *
     * @param cartaoId o ID do cartão de crédito.
     * @param novoLimite o novo limite do cartão de crédito.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public void atualizarLimiteCartaoCredito(Long cartaoId, double novoLimite) throws SQLException {
        String sql = "UPDATE cartao_credito SET limite = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, novoLimite);
            stmt.setLong(2, cartaoId);
            stmt.executeUpdate();
        }
    }
    /**
     * Atualiza o saldo utilizado de um cartão de crédito.
     *
     * @param cartaoId o ID do cartão de crédito.
     * @param novoSaldoUtilizado o novo saldo utilizado do cartão de crédito.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public void atualizarSaldoUtilizadoCartaoCredito(Long cartaoId, double novoSaldoUtilizado) throws SQLException {
        String sql = "UPDATE cartao_credito SET saldo_utilizado = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, novoSaldoUtilizado);
            stmt.setLong(2, cartaoId);
            stmt.executeUpdate();
        }
    }
    /**
     * Busca o saldo de uma conta corrente pelo ID do cliente.
     *
     * @param clienteId o ID do cliente.
     * @return o saldo da conta corrente do cliente, ou null se nenhuma conta for encontrada.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public String buscarSaldoPorClienteId(Long clienteId) throws SQLException {
        String sql = "SELECT saldo FROM conta_corrente WHERE cliente_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, clienteId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("saldo");
                }
            }
        }
        return null;
    }
}
