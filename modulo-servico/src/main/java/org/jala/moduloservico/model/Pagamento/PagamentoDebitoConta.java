package org.jala.moduloservico.model.Pagamento;

import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.DAO.ClienteDAO;

import java.sql.SQLException;
/**
 * Classe que implementa a estratégia de pagamento via débito em conta.
 */
public class PagamentoDebitoConta implements PagamentoStrategy{
    ClienteDAO clienteDAO;
    Cliente cliente;

    /**
     * Construtor da classe PagamentoDebitoConta.
     * @param clienteDAO O DAO do Cliente para acesso ao banco de dados.
     * @param cliente O Cliente que realizará o pagamento.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public PagamentoDebitoConta(ClienteDAO clienteDAO, Cliente cliente) throws SQLException {
        this.clienteDAO = clienteDAO;
        this.cliente = cliente;
    }
    /**
     * Método para realizar o pagamento via débito em conta.
     * @param valor O valor a ser pago.
     * @return true se o pagamento for bem-sucedido, false caso contrário.
     * @throws SQLException Se ocorrer um erro durante o pagamento.
     */
    @Override
    public boolean pagar(Double valor) throws SQLException {
        if(cliente.getContaCorrente().retirarDinheiro(valor)){
            clienteDAO.atualizarSaldoContaCorrente(cliente.getContaCorrente().getId(),cliente.getContaCorrente().getSaldo());
            return true;
        }
        return false;

    }
}
