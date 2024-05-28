package org.jala.moduloservico.model.DAO;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PostgresConnectionTest {

    private static Connection connection;

    @BeforeAll
    public static void setUp() throws SQLException {
        connection = PostgresConnection.getConnection();
    }

    @Test
    public void testConnectionNotNull() {
        assertNotNull(connection);
    }

    @AfterAll
    public static void tearDown() {
        PostgresConnection.closeConnection(connection);
    }
}