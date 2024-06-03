package org.jala.moduloservico.model.Pagamento;

import java.sql.SQLException;
/**
 * Interface que define a estratégia de pagamento.
 */
public interface PagamentoStrategy {
    /**
     * Método para realizar o pagamento de um determinado valor.
     * @param valor O valor a ser pago.
     * @return true se o pagamento for bem-sucedido, false caso contrário.
     * @throws SQLException Se ocorrer um erro durante o pagamento.
     */
    boolean pagar(Double valor) throws SQLException;
}