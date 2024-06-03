package org.jala.moduloservico.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Classe responsável por gerenciar a conexão com o banco de dados PostgreSQL.
 */
public class PostgresConnection {
    private static final String URL = "jdbc:postgresql://fanny.db.elephantsql.com:5432/rsfbcmre";
    private static final String USER = "rsfbcmre";
    private static final String PASSWORD = "HHVZNuMa-CC18OIZExTNCk42dMrvG6Td";

    /**
     * Obtém uma conexão com o banco de dados PostgreSQL.
     *
     * @return a conexão com o banco de dados.
     * @throws SQLException se ocorrer um erro ao tentar se conectar ao banco de dados.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Fecha a conexão com o banco de dados.
     *
     * @param connection a conexão a ser fechada.
     */
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
