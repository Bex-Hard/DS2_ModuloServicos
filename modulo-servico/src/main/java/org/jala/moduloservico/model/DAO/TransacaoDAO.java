package org.jala.moduloservico.model.DAO;

import org.jala.moduloservico.model.Transacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.jala.moduloservico.model.DAO.PostgresConnection.getConnection;

public class TransacaoDAO {

    public void criarTransacao(Transacao transacao) {
        String sql = "INSERT INTO transacoes (id_user, nome_cliente, numero_conta, cpf_cnpj, email_cliente, " +
                "tipo_pagamento, valor, moeda, conta_origem, conta_destino, tipo_servico, numero_cartao, " +
                "descricao, confirmacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, transacao.getIdUser());
            pstmt.setString(2, transacao.getNomeCliente());
            pstmt.setString(3, transacao.getNumeroConta());
            pstmt.setString(4, transacao.getCpfCnpj());
            pstmt.setString(5, transacao.getEmailCliente());
            pstmt.setString(6, String.valueOf(transacao.getTipoPagamento()));
            pstmt.setDouble(7, transacao.getValor());
            pstmt.setString(8, transacao.getMoeda());
            pstmt.setString(9, transacao.getContaOrigem());
            pstmt.setString(10, transacao.getContaDestino() != null ? transacao.getContaDestino() : "");
            pstmt.setString(11, transacao.getTipoServico());
            pstmt.setString(12, transacao.getNumeroCartao());
            pstmt.setString(13, transacao.getDescricao());
            pstmt.setBoolean(14, transacao.getConfirmacao());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
