package org.jala.moduloservico.model.DAO;

import org.jala.moduloservico.model.Transacao;
import org.jala.moduloservico.model.enums.TipoPagamento;
import org.jala.moduloservico.model.enums.TipoServicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.jala.moduloservico.model.DAO.PostgresConnection.getConnection;

public class TransacaoDAO {

    public void inserirTransacao(Transacao transacao) throws SQLException {
        String sql = "INSERT INTO transacoes (id_user, id_transacao, nome_cliente, numero_conta, cpf_cnpj, email_cliente, tipo_pagamento, valor, data_hora_transacao, moeda, conta_origem, conta_destino, tipo_servico, numero_cartao, descricao, confirmacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, transacao.getIdUser());
            stmt.setString(2, transacao.getIdTransacao());
            stmt.setString(3, transacao.getNomeCliente());
            stmt.setString(4, transacao.getNumeroConta());
            stmt.setString(5, transacao.getCpfCnpj());
            stmt.setString(6, transacao.getEmailCliente());
            stmt.setString(7, transacao.getTipoPagamento().name());
            stmt.setDouble(8, transacao.getValor());
            stmt.setObject(9, transacao.getDataHoraTransacao());
            stmt.setString(10, transacao.getMoeda());
            stmt.setString(11, transacao.getContaOrigem());
            stmt.setString(12, transacao.getContaDestino());
            stmt.setString(13, transacao.getTipoServico().name());
            stmt.setString(14, transacao.getNumeroCartao());
            stmt.setString(15, transacao.getDescricao());
            stmt.setBoolean(16, transacao.getConfirmacao());
            stmt.executeUpdate();
        }
    }

    public Transacao buscarTransacaoPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM transacoes WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Transacao transacao = new Transacao(
                            rs.getLong("id_user"),
                            rs.getString("nome_cliente"),
                            rs.getString("numero_conta"),
                            rs.getString("cpf_cnpj"),
                            rs.getString("email_cliente"),
                            rs.getString("id_transacao"),
                            TipoPagamento.valueOf(rs.getString("tipo_pagamento")),
                            rs.getDouble("valor"),
                            rs.getObject("data_hora_transacao", LocalDateTime.class),
                            rs.getString("moeda"),
                            rs.getString("conta_origem"),
                            rs.getString("conta_destino"),
                            TipoServicos.valueOf(rs.getString("tipo_servico")),
                            rs.getString("numero_cartao"),
                            rs.getString("descricao"),
                            rs.getBoolean("confirmacao")
                    );
                    return transacao;
                }
            }
        }
        return null;
    }
}