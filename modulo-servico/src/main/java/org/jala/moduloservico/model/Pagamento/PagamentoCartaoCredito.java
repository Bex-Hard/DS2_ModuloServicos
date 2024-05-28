package org.jala.moduloservico.model.Pagamento;

import org.jala.moduloservico.model.DAO.ClienteDAO;

public class PagamentoCartaoCredito implements PagamentoStrategy {
    ClienteDAO clienteDAO;

    public PagamentoCartaoCredito(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public void pagar() {

    }
}
