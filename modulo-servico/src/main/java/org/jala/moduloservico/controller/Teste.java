package org.jala.moduloservico.controller;


import br.com.caelum.stella.boleto.*;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;

public class Teste {
    public static void main(String[] args) {
        Datas datas = Datas.novasDatas()
                .comDocumento(1, 5, 2008)
                .comProcessamento(1, 5, 2008)
                .comVencimento(2, 5, 2008);

        Endereco enderecoBeneficiario = Endereco.novoEndereco()
                    .comLogradouro(" Av. Melchor Pérez de Olguín 2643, Cochabamba, Bolívia")
                .comBairro("Bairro Grande")
                .comCep("01234-555")
                .comCidade("Cochabamba")
                .comUf("BO");

        //Quem emite o boleto
        Beneficiario beneficiario = Beneficiario.novoBeneficiario()
                .comNomeBeneficiario("JalaBank")
                .comAgencia("1824").
                comDigitoAgencia("4")
                .comCodigoBeneficiario("76000")
                .comDigitoCodigoBeneficiario("5")
                .comNumeroConvenio("1207113")
                .comCarteira("18")
                .comEndereco(enderecoBeneficiario)
                .comNossoNumero("12456789882888888");

        Endereco enderecoPagador = Endereco.novoEndereco()
                .comLogradouro("Av dos testes, 111 apto 333")
                .comBairro("Bairro Teste")
                .comCep("01234-111")
                .comCidade("São Paulo")
                .comUf("SP");

        //Quem paga o boleto
        Pagador pagador = Pagador.novoPagador()
                .comNome("Pedro")
                .comDocumento("111.222.333-12")
                .comEndereco(enderecoPagador);

        Banco banco = new BancoDoBrasil();

        Boleto boleto = Boleto.novoBoleto()
                .comBanco(banco)
                .comDatas(datas)
                .comBeneficiario(beneficiario)
                .comPagador(pagador)
                .comValorBoleto("200.00")
                .comNumeroDoDocumento("1234")
                .comInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5")
                .comLocaisDePagamento("local 1", "local 2");

        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);


        gerador.geraPDF("BoletoOswaldoteste.pdf");

    }
}