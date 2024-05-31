package org.jala.moduloservico.controller;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Endereco;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import org.jala.moduloservico.controller.service.BoletoService;
import org.jala.moduloservico.controller.service.TransacaoService;
import org.jala.moduloservico.model.DTO.BoletoDTO;
import org.jala.moduloservico.model.DTO.TransacaoDTO;
import org.jala.moduloservico.model.Pagamento.FabricaPagamento;
import org.jala.moduloservico.model.enums.TipoPagamento;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.jala.moduloservico.model.enums.TipoServicos.BOLETO;

public class BoletoController implements Initializable {

    @FXML
    public Button gerar_boleto;
    @FXML
    public TextField valor_boleto;
    @FXML
    public DatePicker data_boleto;
    @FXML
    public DatePicker data_vencimento_vencimento;
    @FXML
    public Text erro_campos;

    public Button pagar_boleto;
    public Button baixar_pdf;

    public Label nome_pagador;
    public Label cpf_pagador;
    public Label endereco_pagador;
    public Label codigo_boleto;
    public Label data_vencimento;
    public Label data_processamento;
    public Label texto_codigo_boleto;
    public Label boleto_cliente;


    private BoletoService boletoService;

    private TipoPagamento tipoPagamento;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
        addMonetaryValidation(valor_boleto);


    }
    private void addListeners(){
        gerar_boleto.setOnAction(event -> {
            if (validarCamposBoleto()) {
                pagar_boleto.setVisible(true);
                baixar_pdf.setVisible(true);
                erro_campos.setVisible(false);

                try {
                    Boleto boleto = processarBoleto();
                    mostrarBoletoGerado(boleto);

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
            else {
                erro_campos.setVisible(true);
            }
        }

        );
        baixar_pdf.setOnAction(event -> {
            boletoService.gerarPDFBoleto();
        });
        pagar_boleto.setOnAction(event -> {
                    try {
                        realizarTransacao();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                );

    }
    private void addMonetaryValidation(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d+(\\.\\d{0,2})?")) {
                    textField.setText(oldValue);
                }
            }
        });
    }

    private void realizarTransacao() throws SQLException {
        TransacaoDTO transacaoDTO = infoTransacao();
        FabricaPagamento fabricaPagamento = new FabricaPagamento();
        TransacaoService transacaoService = new TransacaoService(fabricaPagamento, fabricaPagamento.getClienteDAO(), transacaoDTO);
        transacaoService.realizarTransacao();
    }

    private Boleto processarBoleto() throws SQLException {
        LocalDate dataBoletoLocalDate = tranformaLocalDate(data_boleto);
        LocalDate dataBoletoVencimentoLocalDate = tranformaLocalDate(data_vencimento_vencimento);

        BoletoDTO boletoDTO = new BoletoDTO(
                valor_boleto.getText(),
                dataBoletoLocalDate,
                dataBoletoVencimentoLocalDate);


        boletoService = new BoletoService();
        return boletoService.gerarBoleto(boletoDTO);
    }

    private boolean validarCamposBoleto(){
        try {
            double valorBoletoInt = Double.parseDouble(valor_boleto.getText());
        }
        catch (NumberFormatException e){
            return false;
        }
        return data_boleto.getValue() != null && data_vencimento_vencimento.getValue() != null;

    }

    private void mostrarBoletoGerado(Boleto boleto){
        nome_pagador.setText(boleto.getPagador().getNome());
        cpf_pagador.setText(boleto.getPagador().getDocumento());
        endereco_pagador.setText(boleto.getPagador().getEndereco().getEnderecoCompleto());
        boleto_cliente.setText( "R$ " + toString( boleto.getValorBoleto()));
        codigo_boleto.setText(boleto.getCodigoDeBarras());
        data_vencimento.setText(formatarData(tranformaLocalDate(data_boleto)));
        data_processamento.setText(formatarData(tranformaLocalDate(data_vencimento_vencimento)));

        nome_pagador.setVisible(true);
        cpf_pagador.setVisible(true);
        endereco_pagador.setVisible(true);
        boleto_cliente.setVisible(true);
        codigo_boleto.setVisible(true);
        data_vencimento.setVisible(true);
        data_processamento.setVisible(true);
        texto_codigo_boleto.setVisible(true);




    }

    private String formatarData(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));
        return localDate.format(formatter);
    }
    private String toString(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return "";
        }

        // Formatação com duas casas decimais
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(bigDecimal);
    }

    private LocalDate tranformaLocalDate(DatePicker escolhaData){
        return escolhaData.getValue();
    }

    private TransacaoDTO infoTransacao() {
        TransacaoDTO transacaoDTO = new TransacaoDTO();
        transacaoDTO.setTipoServicos(BOLETO);
        transacaoDTO.setTipoPagamento(TipoPagamento.DEBITO_CONTA);
        transacaoDTO.setValorTransacao(valor_boleto.getText());
        transacaoDTO.setDescricao("Pagamento de boleto");
        return transacaoDTO;
    }

}
