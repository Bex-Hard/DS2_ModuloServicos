package org.jala.moduloservico.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    private static final String URL = "jdbc:postgresql://fanny.db.elephantsql.com:5432/rsfbcmre";
    private static final String USER = "rsfbcmre";
    private static final String PASSWORD = "HHVZNuMa-CC18OIZExTNCk42dMrvG6Td";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para fechar a conexão
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
