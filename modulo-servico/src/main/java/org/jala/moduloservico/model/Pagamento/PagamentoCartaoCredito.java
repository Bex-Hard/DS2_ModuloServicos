package org.jala.moduloservico.model.Pagamento;

import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.DAO.ClienteDAO;

import java.sql.SQLException;

public class PagamentoCartaoCredito implements PagamentoStrategy {
    ClienteDAO clienteDAO;
    Cliente cliente;
    Long idCartao;

    public PagamentoCartaoCredito(ClienteDAO clienteDAO, Cliente cliente) throws SQLException {
        this.clienteDAO = clienteDAO;
        this.cliente = cliente;
        this.idCartao = cliente.getContaCorrente().getCartao().getId();
    }

    @Override
    public boolean pagar(Double valor) throws SQLException {

        if(cliente.getContaCorrente().getCartao().usarCredito(valor)){
            clienteDAO.atualizarLimiteCartaoCredito(idCartao,cliente.getContaCorrente().getCartao().getLimite());
            clienteDAO.atualizarSaldoUtilizadoCartaoCredito(idCartao,cliente.getContaCorrente().getCartao().getSaldoUtilizado());
            return true;
        }
        return false;


    }


}
