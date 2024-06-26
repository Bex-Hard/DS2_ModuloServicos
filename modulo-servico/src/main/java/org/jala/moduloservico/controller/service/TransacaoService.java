package org.jala.moduloservico.controller.service;

import org.jala.moduloservico.model.DAO.ClienteDAO;
import org.jala.moduloservico.model.DAO.TransacaoDAO;
import org.jala.moduloservico.model.DTO.TransacaoDTO;
import org.jala.moduloservico.model.Pagamento.FabricaPagamento;
import org.jala.moduloservico.model.Pagamento.PagamentoStrategy;
import org.jala.moduloservico.model.Transacao;
import org.jala.moduloservico.model.enums.TipoPagamento;
import org.jala.moduloservico.model.enums.TipoServicos;

import java.sql.SQLException;
/**
 * Responsável por realizar uma transação de pagamento.
 */
public class TransacaoService {
    private Transacao transacao;
    private FabricaPagamento pagamentoFactory;
    private ClienteDAO clienteDAO;
    private TransacaoDTO transacaoDTO;
    private TransacaoDAO transacaoDAO;


    /**
     * Construtor da classe TransacaoService.
     *
     * @param pagamentoFactory a fábrica de pagamentos para obter a estratégia de pagamento
     * @param clienteDAO o DAO do cliente para atualizar as informações de transação
     * @param transacaoDTO o DTO da transação contendo as informações do pagamento
     */
    public TransacaoService(FabricaPagamento pagamentoFactory, ClienteDAO clienteDAO, TransacaoDTO transacaoDTO) {
        this.pagamentoFactory = pagamentoFactory;
        this.clienteDAO = clienteDAO;
        this.transacaoDTO = transacaoDTO;
        this.transacao = new Transacao();
        this.transacaoDAO = new TransacaoDAO();
        criarTransacao();

    }
    /**
     * Realiza a transação de pagamento.
     *
     * @throws SQLException se ocorrer um erro ao realizar a transação no banco de dados
     */
    public Boolean realizarTransacao() throws SQLException {
        PagamentoStrategy pagamentoStrategy = pagamentoFactory.getPagamentoStrategy(transacao.getTipoPagamento());
        Double valorDouble = Double.parseDouble(transacaoDTO.getValor());
        return fazerPagamento(pagamentoStrategy, valorDouble);
    }
    /**
     * Atualiza o status da transação com base na estratégia de pagamento.
     *
     * @param pagamentoStrategy a estratégia de pagamento utilizada na transação
     * @param valorDouble o valor da transação
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados
     */
    private Boolean fazerPagamento(PagamentoStrategy pagamentoStrategy, Double valorDouble) throws SQLException {
        if (pagamentoStrategy.pagar(valorDouble)) {
            transacao.setConfirmacao(true);
            transacaoDAO.criarTransacao(transacao);
            return true;
        }
        else {
            transacao.setConfirmacao(false);
            transacaoDAO.criarTransacao(transacao);
            return false;
        }
    }

    /**
     * Cria a transação com base nas informações do DTO de transação.
     */
    private void criarTransacao(){
        transacao.setIdUser(pagamentoFactory.getCliente().getId());
        transacao.setNomeCliente(pagamentoFactory.getCliente().getNome());
        transacao.setNumeroConta(pagamentoFactory.getCliente().getContaCorrente().getNumeroConta());
        transacao.setCpfCnpj(pagamentoFactory.getCliente().getCpf());
        transacao.setEmailCliente(pagamentoFactory.getCliente().getEmail());
        transacao.setTipoPagamento(TipoPagamento.valueOf(String.valueOf(transacaoDTO.getTipoPagamento())));
        transacao.setValor(Double.parseDouble(transacaoDTO.getValor()));
        transacao.setMoeda("R$");
        transacao.setContaOrigem(pagamentoFactory.getCliente().getContaCorrente().getNumeroConta());
        transacao.setContaDestino(null);
        transacao.setTipoServico(TipoServicos.valueOf(String.valueOf(transacaoDTO.getTipoServicos())));
        transacao.setNumeroCartao(pagamentoFactory.getCliente().getContaCorrente().getCartao().getNumeroCartao());
        transacao.setDescricao(transacaoDTO.getDescricao());

    }

}

