package org.jala.moduloservico.model.Pagamento;

import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.DAO.ClienteDAO;
import org.jala.moduloservico.model.enums.TipoPagamento;

import java.sql.SQLException;

public class FabricaPagamento {
    private final ClienteDAO clienteDAO;
    private final Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public FabricaPagamento() throws SQLException {
        this.clienteDAO = inicarCliente();
        this.cliente = clienteDAO.buscarClientePorId(1L);
    }

    public PagamentoStrategy getPagamentoStrategy(TipoPagamento tipoPagamento) throws SQLException {
        return switch (tipoPagamento) {
            case CARTAO_CREDITO -> new PagamentoCartaoCredito(this.clienteDAO, cliente);
            case DEBITO -> new PagamentoDebitoConta(this.clienteDAO,cliente);
        };
    }

    public ClienteDAO inicarCliente(){
        return new ClienteDAO();
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }
}
