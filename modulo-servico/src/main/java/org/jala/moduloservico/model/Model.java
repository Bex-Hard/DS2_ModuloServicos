package org.jala.moduloservico.model;

import org.jala.moduloservico.view.ViewFactory;

/**
 * Instancia a fábrica da interface gráfica
 */
public class Model {

    private static Model model;
    private final ViewFactory viewFactory;

    /**
     * Construtor privado para evitar instanciação direta.
     */
    private Model() {
        this.viewFactory = new ViewFactory();
    }
    /**
     * Método para obter a fábrica da interface gráfica.
     * @return A fábrica da interface gráfica.
     */
    public ViewFactory getViewFactory() {
        return viewFactory;
    }
    /**
     * Método para obter a instância única de Model.
     * @return A instância única de Model.
     */
    public static synchronized Model getInstance(){
        if (model == null){
            model = new Model();
        }
        return model;
    }
}
