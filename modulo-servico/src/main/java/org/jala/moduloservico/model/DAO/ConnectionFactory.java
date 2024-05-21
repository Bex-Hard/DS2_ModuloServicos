package org.jala.moduloservico.model.DAO;

import java.sql.Connection;

public interface ConnectionFactory {

    Connection getConnection();
    
}
