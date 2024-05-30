package org.jala.moduloservico.model.Pagamento;

import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.DAO.ClienteDAO;

public class PagamentoCartaoDebito implements PagamentoStrategy{
    ClienteDAO clienteDAO;
    Cliente cliente;

    public PagamentoCartaoDebito(ClienteDAO clienteDAO, Long clientId) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public void pagar() {

    }
}
