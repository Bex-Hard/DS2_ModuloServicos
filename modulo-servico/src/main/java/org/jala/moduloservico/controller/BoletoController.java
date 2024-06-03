package org.jala.moduloservico.controller;

import br.com.caelum.stella.boleto.Boleto;
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
import org.jala.moduloservico.util.SenhaUtil;
import org.jala.moduloservico.util.ValidacaoInputUsuario;

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
    @FXML
    public Button pagar_boleto;
    @FXML
    public Button baixar_pdf;
    @FXML
    public Label nome_pagador;
    @FXML
    public Label cpf_pagador;
    @FXML
    public Label endereco_pagador;
    @FXML
    public Label codigo_boleto;
    @FXML
    public Label data_vencimento;
    @FXML
    public Label data_processamento;
    @FXML
    public Label texto_codigo_boleto;
    @FXML
    public Label boleto_cliente;


    private BoletoService boletoService;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
        ValidacaoInputUsuario.addMonetaryValidation(valor_boleto);
        ValidacaoInputUsuario.addDateValidation(data_boleto);
        ValidacaoInputUsuario.addDateValidation(data_vencimento_vencimento);
        pagar_boleto.setOnAction(event -> solicitarConfirmacaoSenha());


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


    }
    private void solicitarConfirmacaoSenha() {
        SenhaUtil.solicitarSenha(senhaCorreta -> {
            if (senhaCorreta) {
                try {
                    realizarTransacao();

                } catch (SQLException e) {
                    e.printStackTrace();
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
        transacaoDTO.setTipoPagamento(TipoPagamento.DEBITO);
        transacaoDTO.setValor(valor_boleto.getText());
        transacaoDTO.setDescricao("Pagamento de boleto");
        return transacaoDTO;
    }

}
