package org.jala.moduloservico.controller;

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

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static org.jala.moduloservico.model.enums.TipoServicos.BOLETO;

public class BoletoController implements Initializable {

    @FXML
    public Button gerar_boleto;
    @FXML
    public ChoiceBox<String> forma_pagmento;
    @FXML
    public TextField valor_boleto;
    @FXML
    public DatePicker data_boleto;
    @FXML
    public DatePicker data_vencimento_vencimento;
    @FXML
    public Text erro_campos;

    private final String[] metodosPgamento = {"Cartão de Débito","Cartão de Crédito","PIX"};


    private BoletoService boletoService;

    private TipoPagamento tipoPagamento;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        forma_pagmento.getItems().addAll(metodosPgamento);
        addListeners();

    }
    private void addListeners(){
        gerar_boleto.setOnAction(event -> {
            if (validarCamposBoleto()) {
                erro_campos.setVisible(false);


                realizarTransacao();

                processarBoleto();
                mostrarBoletoGerado(boletoService);

            }
            else {
                erro_campos.setVisible(true);
            }
        });
    }

    private void realizarTransacao() {
        TransacaoDTO transacaoDTO = infoTransacao();
        FabricaPagamento fabricaPagamento = new FabricaPagamento();
        TransacaoService transacaoService = new TransacaoService(fabricaPagamento, fabricaPagamento.getClienteDAO(), transacaoDTO);
        transacaoService.realizarTransacao();
    }

    private void processarBoleto() {
        LocalDate dataBoletoLocalDate = tranformaLocalDate(data_boleto);
        LocalDate dataBoletoVencimentoLocalDate = tranformaLocalDate(data_vencimento_vencimento);

        BoletoDTO boletoDTO = new BoletoDTO(
                valor_boleto.getText(),
                dataBoletoLocalDate,
                dataBoletoVencimentoLocalDate);


        boletoService = new BoletoService();
        boletoService.gerarBoleto(boletoDTO);
    }

    private boolean validarCamposBoleto(){
        try {
            int valorBoletoInt = Integer.parseInt(valor_boleto.getText());
        }
        catch (NumberFormatException e){
            return false;
        }
        return data_boleto.getValue() != null && data_vencimento_vencimento.getValue() != null;

    }

    private void mostrarBoletoGerado(BoletoService boletoService){
    }

    private LocalDate tranformaLocalDate(DatePicker escolhaData){
        return escolhaData.getValue();
    }

    private TransacaoDTO infoTransacao() {
        TransacaoDTO transacaoDTO = new TransacaoDTO();
        transacaoDTO.setTipoServicos(BOLETO);
        transacaoDTO.setTipoPagamento(TipoPagamento.CARTAO_CREDITO);
        transacaoDTO.setValorTransacao(valor_boleto.getText());
        transacaoDTO.setDescricao("Pagamento de boleto");
        return transacaoDTO;

    }

}
