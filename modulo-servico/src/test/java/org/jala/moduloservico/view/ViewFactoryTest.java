package org.jala.moduloservico.view;

import javafx.scene.layout.AnchorPane;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ViewFactoryTest {

    @Test
    public void testGetContaViewNotNull() {
        ViewFactory viewFactory = new ViewFactory();
        AnchorPane contaView = viewFactory.getContaView();
        assertNotNull(contaView);
    }

    @Test
    public void testGetCartoesViewNotNull() {
        ViewFactory viewFactory = new ViewFactory();
        AnchorPane cartoesView = viewFactory.getCartoesView();
        assertNotNull(cartoesView);
    }

    @Test
    public void testGetEmprestimoViewNotNull() {
        ViewFactory viewFactory = new ViewFactory();
        AnchorPane emprestimoView = viewFactory.getEmprestimoView();
        assertNotNull(emprestimoView);
    }

    // Adicione mais testes para os outros métodos da classe ViewFactory conforme necessário

}