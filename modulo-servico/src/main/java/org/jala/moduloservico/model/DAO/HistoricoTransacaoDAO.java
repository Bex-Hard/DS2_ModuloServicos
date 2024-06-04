package org.jala.moduloservico.model.DAO;

import org.jala.moduloservico.model.Transacao;
import org.jala.moduloservico.model.enums.TipoPagamento;
import org.jala.moduloservico.model.enums.TipoServicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;



import static org.jala.moduloservico.model.DAO.PostgresConnection.getConnection;

/**
 * Classe responsável pelo acesso aos dados do histórico de transações no banco de dados.
 */
public class HistoricoTransacaoDAO {


    /**
     * Lista todas as transações de um cliente específico, ordenadas pela data e hora da transação em ordem decrescente.
     *
     * @param idUser o ID do usuário cujas transações serão listadas.
     * @return uma lista de transações do usuário.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public List<Transacao> listarTransacoesPorCliente(Long idUser) throws SQLException {
        String sql = "SELECT * FROM transacoes WHERE id_user = ? ORDER BY data_hora_transacao DESC";
        List<Transacao> transacoes = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, idUser);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String dataHoraFormatada = rs.getTimestamp("data_hora_transacao")
                            .toLocalDateTime()
                            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));


                    Transacao transacao = new Transacao(
                            rs.getLong("id_user"),
                            rs.getString("nome_cliente"),
                            rs.getString("numero_conta"),
                            rs.getString("cpf_cnpj"),
                            rs.getString("email_cliente"),
                            rs.getString("id"),
                            TipoPagamento.valueOf(rs.getString("tipo_pagamento")),
                            rs.getDouble("valor"),
                            dataHoraFormatada,
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
