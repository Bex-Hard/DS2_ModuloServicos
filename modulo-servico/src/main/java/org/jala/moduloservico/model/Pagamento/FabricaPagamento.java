package org.jala.moduloservico.model.Pagamento;

import org.jala.moduloservico.model.DAO.ClienteDAO;
import org.jala.moduloservico.model.enums.TipoPagamento;

public class FabricaPagamento {
    private ClienteDAO clienteDAO;

    public FabricaPagamento() {
        this.clienteDAO = inicarCliente();
    }

    public PagamentoStrategy getPagamentoStrategy(TipoPagamento tipoPagamento) {
        return switch (tipoPagamento) {
            case CARTAO_CREDITO -> new PagamentoCartaoCredito(this.clienteDAO);
            case CARTAO_DEBITO -> new PagamentoCartaoDebito(this.clienteDAO);
            case PIX -> new PagamentoPix(this.clienteDAO);
        };
    }

    public ClienteDAO inicarCliente(){
        return new ClienteDAO();
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }
}
