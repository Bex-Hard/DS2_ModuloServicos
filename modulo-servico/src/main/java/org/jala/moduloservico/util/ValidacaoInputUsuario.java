package org.jala.moduloservico.util;


import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;


public class ValidacaoInputUsuario {

    /**
     * Método para adicionar validação de valores monetários a um TextField.
     * Permite apenas números e até duas casas decimais.
     * @param textField O TextField a ser validado.
     */
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
    /**
     * Método para adicionar validação de datas a um DatePicker.
     * Permite apenas números e barras (/) no editor de texto do DatePicker.
     * @param datePicker O DatePicker a ser validado.
     */
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
    /**
     * Método para adicionar validação de números de telefone a um TextField.
     * Permite apenas números, caracteres específicos para números de telefone e limita o comprimento máximo a 11 caracteres.
     * @param textField O TextField a ser validado.
     */
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
    /**
     * Adiciona validação ao TextField para permitir apenas números inteiros e
     * limita o comprimento máximo a 16 caracteres.
     *
     * @param textField o campo de texto a ser validado
     */
    public static void addCardValidation(TextField textField) {
        // Adiciona um ChangeListener ao TextField
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Permite apenas números inteiros
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
                // Limita o comprimento máximo a 16 caracteres
                if (newValue.length() > 16) {
                    textField.setText(oldValue);
                }
            }
        });
    }

}
