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

    opens org.jala.moduloservico to javafx.fxml;
    exports org.jala.moduloservico;
    exports org.jala.moduloservico.controller;
    exports org.jala.moduloservico.view;
    exports org.jala.moduloservico.model;




}