package org.jala.moduloservico.model.Pagamento;

import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.DAO.ClienteDAO;

import java.sql.SQLException;
/**
 * Classe que implementa a estratégia de pagamento via cartão de crédito.
 */

public class PagamentoCartaoCredito implements PagamentoStrategy {
    ClienteDAO clienteDAO;
    Cliente cliente;
    Long idCartao;

    /**
     * Construtor da classe PagamentoCartaoCredito.
     * @param clienteDAO O DAO do Cliente para acesso ao banco de dados.
     * @param cliente O Cliente que realizará o pagamento.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public PagamentoCartaoCredito(ClienteDAO clienteDAO, Cliente cliente) throws SQLException {
        this.clienteDAO = clienteDAO;
        this.cliente = cliente;
        this.idCartao = cliente.getContaCorrente().getCartao().getId();
    }
    /**
     * Método para realizar o pagamento via cartão de crédito.
     * @param valor O valor a ser pago.
     * @return true se o pagamento for bem-sucedido, false caso contrário.
     * @throws SQLException Se ocorrer um erro durante o pagamento.
     */
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
