package org.jala.moduloservico.model.Pagamento;

import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.DAO.ClienteDAO;
import org.jala.moduloservico.model.enums.TipoPagamento;

import java.sql.SQLException;

public class FabricaPagamento {
    private ClienteDAO clienteDAO;
    private Cliente cliente;

    public FabricaPagamento() throws SQLException {
        this.clienteDAO = inicarCliente();
        this.cliente = clienteDAO.buscarClientePorId(1L);
    }

    public PagamentoStrategy getPagamentoStrategy(TipoPagamento tipoPagamento) {
        return switch (tipoPagamento) {
            case CARTAO_CREDITO -> new PagamentoCartaoCredito(this.clienteDAO, cliente.getId());
            case DEBITO_CONTA -> new PagamentoCartaoDebito(this.clienteDAO,cliente.getId());
            case PIX -> new PagamentoPix(this.clienteDAO,cliente.getId());
        };
    }

    public ClienteDAO inicarCliente(){
        return new ClienteDAO();
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }
}
