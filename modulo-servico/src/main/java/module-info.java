module org.jala.moduloservico {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.postgresql.jdbc;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires caelum.stella.boleto;
    requires java.persistence;
    requires jcommander;
    requires java.xml.bind;
    requires ecj;

    opens org.jala.moduloservico to javafx.fxml;
    exports org.jala.moduloservico;
    exports org.jala.moduloservico.controller;
    exports org.jala.moduloservico.view;
    exports org.jala.moduloservico.model;
    exports org.jala.moduloservico.controller.service;
    opens org.jala.moduloservico.controller.service to javafx.fxml;
    exports org.jala.moduloservico.model.DTO;
    opens org.jala.moduloservico.model.DTO to javafx.fxml;
    opens org.jala.moduloservico.controller to javafx.fxml;


}