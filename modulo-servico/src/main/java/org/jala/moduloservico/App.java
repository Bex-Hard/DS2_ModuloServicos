package org.jala.moduloservico;

import org.jala.moduloservico.model.Model;
import javafx.application.Application;
import javafx.stage.Stage;
import org.jala.moduloservico.util.StartCliente;


public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Model.getInstance().getViewFactory().mostrarClienteMenu();
    }
}

