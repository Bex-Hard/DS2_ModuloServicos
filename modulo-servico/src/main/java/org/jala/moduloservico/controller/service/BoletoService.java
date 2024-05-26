package org.jala.moduloservico.controller.service;

import br.com.caelum.stella.boleto.*;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.DAO.ClienteDAO;
import org.jala.moduloservico.model.DTO.BoletoDTO;

import java.util.Calendar;

public class BoletoService {

    private Datas datas;
    private Endereco enderecoBeneficiario;
    private Endereco enderecoPagador;
    private Beneficiario beneficiario;
    private Pagador pagador;
    private Banco banco;
    private Boleto boleto;
    private Cliente cliente;

    public Boleto getBoleto() {
        return boleto;
    }

    private ClienteDAO clienteDAO;
    private GeradorDeBoleto gerador;


    public BoletoService() {

        this.banco = new BancoDoBrasil();
        this.clienteDAO = new ClienteDAO();
        this.cliente = clienteDAO.getClienteById(1);
    }

    public Boleto gerarBoleto(BoletoDTO boletoDTO){
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH) + 1;
        int ano = calendar.get(Calendar.YEAR);


        datas = Datas.novasDatas()
                .comDocumento(dia, mes, ano)
                .comProcessamento(dia, mes, ano)
                .comVencimento(dia, mes+1, ano);

        enderecoBeneficiario = Endereco.novoEndereco()
                .comLogradouro(" Av. Melchor Pérez de Olguín 2643, Cochabamba, Bolívia")
                .comBairro("Bairro Grande")
                .comCep("01234-555")
                .comCidade("Cochabamba")
                .comUf("BO");

        beneficiario = Beneficiario.novoBeneficiario()
                .comNomeBeneficiario("JalaBank")
                .comAgencia("1824").
                comDigitoAgencia("4")
                .comCodigoBeneficiario("76000")
                .comDigitoCodigoBeneficiario("5")
                .comNumeroConvenio("1207113")
                .comCarteira("18")
                .comEndereco(enderecoBeneficiario)
                .comNossoNumero("12456789882888888");

        enderecoPagador = Endereco.novoEndereco()
                .comLogradouro(cliente.getLogradouro())
                .comBairro(cliente.getBairro())
                .comCep(cliente.getCep())
                .comCidade(cliente.getCidade())
                .comUf(cliente.getUf());

        pagador = Pagador.novoPagador()
                .comNome(cliente.getNome())
                .comDocumento(cliente.getCpf())
                .comEndereco(enderecoPagador);

        boleto = Boleto.novoBoleto()
                .comBanco(banco)
                .comDatas(datas)
                .comBeneficiario(beneficiario)
                .comPagador(pagador)
                .comValorBoleto(boletoDTO.getValorBoleto())
                .comNumeroDoDocumento("1234")
                .comInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5")
                .comLocaisDePagamento("local 1", "local 2");
        //gerarPDFBoleto();
        return boleto;
    }

    public void gerarPDFBoleto(){
        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);
        gerador.geraPDF("Boleto_JalaBank.pdf");
    }

    private void gerarDataBoleto (){

    }


}
