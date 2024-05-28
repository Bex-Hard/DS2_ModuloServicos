package org.jala.moduloservico.model.Pagamento;

import org.jala.moduloservico.model.DAO.ClienteDAO;

public class PagamentoPix implements PagamentoStrategy{
    ClienteDAO clienteDAO;

    public PagamentoPix(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public void pagar() {

    }
}
