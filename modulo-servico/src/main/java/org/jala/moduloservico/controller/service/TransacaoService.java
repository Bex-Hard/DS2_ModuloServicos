package org.jala.moduloservico.controller.service;

import org.jala.moduloservico.model.DAO.ClienteDAO;
import org.jala.moduloservico.model.DTO.TransacaoDTO;
import org.jala.moduloservico.model.Pagamento.FabricaPagamento;
import org.jala.moduloservico.model.Pagamento.PagamentoStrategy;
import org.jala.moduloservico.model.Transacao;
import org.jala.moduloservico.model.enums.TipoPagamento;

public class TransacaoService {
    private Transacao transacao;
    private TipoPagamento tipoPagamento;
    private FabricaPagamento pagamentoFactory;
    private ClienteDAO clienteDAO;
    private TransacaoDTO transacaoDTO;

    public TransacaoService(FabricaPagamento pagamentoFactory, ClienteDAO clienteDAO, TransacaoDTO transacaoDTO) {
        this.pagamentoFactory = pagamentoFactory;
        this.clienteDAO = clienteDAO;
        this.transacaoDTO = transacaoDTO;
    }

    public void realizarTransacao() {
        PagamentoStrategy pagamentoStrategy = pagamentoFactory.getPagamentoStrategy(transacao.getTipoPagamento());
        pagamentoStrategy.pagar();
    }


    public void criarTransacao(){
        transacao.setTipoPagamento(transacaoDTO.getTipoPagamento());
        transacao.setDescricao(transacaoDTO.getDescricao());
        transacao.setTipoServico(transacaoDTO.getTipoServicos());
        transacao.setValor(Integer.parseInt(transacaoDTO.getValorTransacao()));
        //Implementação do DaoCliente


    }
}

