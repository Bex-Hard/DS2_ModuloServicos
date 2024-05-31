package org.jala.moduloservico.model.Pagamento;

import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.DAO.ClienteDAO;

import java.sql.SQLException;

public class PagamentoPix implements PagamentoStrategy{
    ClienteDAO clienteDAO;
    Cliente cliente;

    public PagamentoPix(ClienteDAO clienteDAO, Cliente cliente) {
        this.clienteDAO = clienteDAO;
        this.cliente = cliente;
    }

    @Override
    public boolean pagar(Double valor) throws SQLException {
        if(cliente.getContaCorrente().retirarDinheiro(valor)){
            clienteDAO.atualizarSaldoContaCorrente(cliente.getContaCorrente().getId(),cliente.getContaCorrente().getSaldo());
            return true;
        }
        return false;

    }
}
