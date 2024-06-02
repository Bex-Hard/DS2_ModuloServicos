package org.jala.moduloservico.model.DAO;

import org.jala.moduloservico.model.Transacao;
import org.jala.moduloservico.model.enums.TipoPagamento;
import org.jala.moduloservico.model.enums.TipoServicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.jala.moduloservico.model.DAO.PostgresConnection.getConnection;


public class HistoricoTransacaoDAO {

    public List<Transacao> listarTransacoesPorCliente(Long idUser) throws SQLException {
        String sql = "SELECT * FROM transacoes WHERE id_user = ? ORDER BY data_hora_transacao DESC";
        List<Transacao> transacoes = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, idUser);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Transacao transacao = new Transacao(
                            rs.getLong("id_user"),
                            rs.getString("nome_cliente"),
                            rs.getString("numero_conta"),
                            rs.getString("cpf_cnpj"),
                            rs.getString("email_cliente"),
                            rs.getString("id_transacao"),
                            TipoPagamento.valueOf(rs.getString("tipo_pagamento")),
                            rs.getDouble("valor"),
                            rs.getTimestamp("data_hora_transacao").toLocalDateTime(),
                            rs.getString("moeda"),
                            rs.getString("conta_origem"),
                            rs.getString("conta_destino"),
                            TipoServicos.valueOf(rs.getString("tipo_servico")),
                            rs.getString("numero_cartao"),
                            rs.getString("descricao"),
                            rs.getBoolean("confirmacao")
                    );
                    transacoes.add(transacao);
                }
            }
        }
        return transacoes;
    }
}
