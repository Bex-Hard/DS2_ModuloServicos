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

    }

}

