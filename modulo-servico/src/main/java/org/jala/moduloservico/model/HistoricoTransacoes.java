package org.jala.moduloservico.model;

import java.util.ArrayList;
import java.util.List;

public class HistoricoTransacoes {

    /**
     * Lista para armazenar as transações
     */
    private List<Transacao> transacoes;

    /**
     * Construtor
     */
    public HistoricoTransacoes() {
        this.transacoes = new ArrayList<>();
    }

    /**
     * Método para adicionar uma transação ao histórico
     * @param transacao
     */
    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    /**
     * Método para remover uma transação do histórico
     * @param transacao
     */
    public void removerTransacao(Transacao transacao) {
        transacoes.remove(transacao);
    }

    /**
     * Método para obter a lista de transações
     * @return
     */
    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    /**
     * Método para obter uma transação específica pelo ID
     * @param idTransacao
     * @return
     */
    public Transacao getTransacaoPorId(String idTransacao) {
        for (Transacao transacao : transacoes) {
            if (transacao.getIdTransacao().equals(idTransacao)) {
                return transacao;
            }
        }
        return null;
    }

    /**
     * Método para listar todas as transações
     * @return
     */
    @Override
    public String toString() {
        StringBuilder historico = new StringBuilder();
        for (Transacao transacao : transacoes) {
            historico.append(transacao.toString()).append("\n");
        }
        return historico.toString();
    }
}
