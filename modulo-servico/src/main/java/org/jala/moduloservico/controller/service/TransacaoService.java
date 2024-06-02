package org.jala.moduloservico.controller.service;

import org.jala.moduloservico.model.DAO.ClienteDAO;
import org.jala.moduloservico.model.DAO.HistoricoTransacaoDAO;
import org.jala.moduloservico.model.DTO.TransacaoDTO;
import org.jala.moduloservico.model.Pagamento.FabricaPagamento;
import org.jala.moduloservico.model.Pagamento.PagamentoStrategy;
import org.jala.moduloservico.model.Transacao;

import java.sql.SQLException;
import java.util.List;

public class TransacaoService {
    private Transacao transacao;
    private FabricaPagamento pagamentoFactory;
    private ClienteDAO clienteDAO;
    private TransacaoDTO transacaoDTO;

    private HistoricoTransacaoDAO historicoTransacaoDAO = new HistoricoTransacaoDAO();

    public TransacaoService(FabricaPagamento pagamentoFactory, ClienteDAO clienteDAO, TransacaoDTO transacaoDTO) {
        this.pagamentoFactory = pagamentoFactory;
        this.clienteDAO = clienteDAO;
        this.transacaoDTO = transacaoDTO;
        this.transacao = new Transacao();
        criarTransacao();
    }

    public void realizarTransacao() throws SQLException {
        PagamentoStrategy pagamentoStrategy = pagamentoFactory.getPagamentoStrategy(transacao.getTipoPagamento());
        Double valorDouble = Double.parseDouble(transacaoDTO.getValor());
        atulizarStatusTransacao(pagamentoStrategy, valorDouble);
    }

    private void atulizarStatusTransacao(PagamentoStrategy pagamentoStrategy, Double valorDouble) throws SQLException {
        if (pagamentoStrategy.pagar(valorDouble)) {
            transacao.setConfirmacao(true);
        }
        else {
            transacao.setConfirmacao(false);
        }
    }


    private void criarTransacao(){
        transacao.setTipoPagamento(transacaoDTO.getTipoPagamento());
        transacao.setDescricao(transacaoDTO.getDescricao());
        transacao.setTipoServico(transacaoDTO.getTipoServicos());
        transacao.setValor(Double.parseDouble(transacaoDTO.getValor()));
        //Implementação do DaoCliente


    }

    public void exibirHistorico(Long clienteId) {
        try {
            List<Transacao> historico = historicoTransacaoDAO.listarTransacoesPorCliente(clienteId);
            if (historico.isEmpty()) {
                System.out.println("Nenhuma transação encontrada para o cliente.");
                return;
            }

            System.out.println("Histórico de Transações:");
            for (Transacao transacao : historico) {
                System.out.println("ID Transação: " + transacao.getIdTransacao());
                System.out.println("Nome Cliente: " + transacao.getNomeCliente());
                System.out.println("Número da Conta: " + transacao.getNumeroConta());
                System.out.println("CPF/CNPJ: " + transacao.getCpfCnpj());
                System.out.println("Email Cliente: " + transacao.getEmailCliente());
                System.out.println("Tipo de Pagamento: " + transacao.getTipoPagamento());
                System.out.println("Valor: " + transacao.getValor());
                System.out.println("Data e Hora: " + transacao.getDataHoraTransacao());
                System.out.println("Moeda: " + transacao.getMoeda());
                System.out.println("Conta Origem: " + transacao.getContaOrigem());
                System.out.println("Conta Destino: " + transacao.getContaDestino());
                System.out.println("Tipo de Serviço: " + transacao.getTipoServico());
                System.out.println("Número do Cartão: " + transacao.getNumeroCartao());
                System.out.println("Descrição: " + transacao.getDescricao());
                System.out.println("Confirmação: " + transacao.getConfirmacao());
                System.out.println("=======================================");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar o histórico de transações.");
        }
    }
}

