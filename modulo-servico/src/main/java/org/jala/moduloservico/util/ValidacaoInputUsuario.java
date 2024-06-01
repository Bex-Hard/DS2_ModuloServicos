package org.jala.moduloservico.util;


import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.DateCell;
import javafx.scene.control.TextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidacaoInputUsuario {

    public static void addMonetaryValidation(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*(\\.\\d{0,2})?")) {
                    textField.setText(oldValue);
                }
            }
        });
    }
    public static void addDateValidation(DatePicker datePicker) {
        // Adiciona um ChangeListener ao editor de texto do DatePicker
        TextField editor = datePicker.getEditor();
        editor.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Permite apenas números e barras (/)
                if (!newValue.matches("[0-9/]*")) {
                    editor.setText(newValue.replaceAll("[^0-9/]", ""));
                }
            }
        });
    }

    public static void addPhoneValidation(TextField textField) {
        // Adiciona um ChangeListener ao TextField
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Permite apenas números e caracteres específicos para números de telefone
                if (!newValue.matches("[0-9+()\\-\\s]*")) {
                    textField.setText(newValue.replaceAll("[^0-9+()\\-\\s]", ""));
                }
                // Limita o comprimento máximo a 11 caracteres
                if (newValue.length() > 11) {
                    textField.setText(oldValue);
                }
            }
        });
    }

}
