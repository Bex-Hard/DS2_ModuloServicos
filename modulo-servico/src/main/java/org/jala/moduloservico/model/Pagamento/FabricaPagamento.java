package org.jala.moduloservico.model.Pagamento;

import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.DAO.ClienteDAO;
import org.jala.moduloservico.model.enums.TipoPagamento;
import org.jala.moduloservico.util.StartCliente;

import java.sql.SQLException;
/**
 * Classe responsável por fabricar estratégias de pagamento com base no tipo de pagamento.
 */
public class FabricaPagamento {

    private final ClienteDAO clienteDAO;
    private final Cliente cliente;


    /**
     * Construtor da classe FabricaPagamento.
     *
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public FabricaPagamento() throws SQLException {
        this.clienteDAO = new ClienteDAO();
        this.cliente = StartCliente.getInstance().getCliente();
    }

    /**
     * Retorna o cliente associado à fábrica de pagamento.
     *
     * @return o cliente associado.
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**
     * Cria uma estratégia de pagamento com base no tipo de pagamento fornecido.
     *
     * @param tipoPagamento o tipo de pagamento para o qual criar a estratégia.
     * @return a estratégia de pagamento correspondente.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public PagamentoStrategy getPagamentoStrategy(TipoPagamento tipoPagamento) throws SQLException {
        return switch (tipoPagamento) {
            case CARTAO_CREDITO -> new PagamentoCartaoCredito(this.clienteDAO, cliente);
            case DEBITO_CONTA -> new PagamentoDebitoConta(this.clienteDAO,cliente);
        };
    }

    /**
     * Retorna o DAO do cliente.
     *
     * @return o DAO do cliente.
     */
    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }
}
