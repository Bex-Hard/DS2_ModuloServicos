package org.jala.moduloservico.model.Pagamento;

import java.sql.SQLException;

public interface PagamentoStrategy {
    boolean pagar(Double valor) throws SQLException;
}