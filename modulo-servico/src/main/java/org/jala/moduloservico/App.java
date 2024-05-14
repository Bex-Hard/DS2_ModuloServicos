package org.jala.moduloservico;

import javafx.application.Application;
import javafx.stage.Stage;
import org.jala.moduloservico.model.Model;


public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Model.getInstance().getViewFactory().mostrarClienteMenu();
    }
}

