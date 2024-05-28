package org.jala.moduloservico.model.Pagamento;

import org.jala.moduloservico.model.DAO.ClienteDAO;

public class PagamentoCartaoDebito implements PagamentoStrategy{
    ClienteDAO clienteDAO;

    public PagamentoCartaoDebito(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public void pagar() {

    }
}
