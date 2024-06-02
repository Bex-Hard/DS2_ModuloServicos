package org.jala.moduloservico.util;

import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.DAO.ClienteDAO;

import java.sql.SQLException;

public class StartCliente {
    private static StartCliente instance;
    private final ClienteDAO clienteDAO;
    private Cliente cliente;

    // Construtor privado para evitar instanciação direta
    private StartCliente() {
        this.clienteDAO = new ClienteDAO();
        try {
            this.cliente = clienteDAO.buscarClientePorId(1L);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obter a instância única de StartCliente
    public static synchronized StartCliente getInstance() {
        if (instance == null) {
            instance = new StartCliente();
        }
        return instance;
    }

    // Método para obter o cliente
    public Cliente getCliente() {
        return cliente;
    }
}
