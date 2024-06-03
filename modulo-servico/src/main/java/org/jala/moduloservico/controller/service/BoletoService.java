package org.jala.moduloservico.controller.service;

import br.com.caelum.stella.boleto.*;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import org.jala.moduloservico.model.Cliente;
import org.jala.moduloservico.model.DAO.ClienteDAO;
import org.jala.moduloservico.model.DTO.BoletoDTO;
import org.jala.moduloservico.util.StartCliente;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
/**
 * Responsável pela geração e manipulação de boletos de pagamento.
 */
public class BoletoService {

    private Datas datas;
    private Endereco enderecoBeneficiario;
    private Endereco enderecoPagador;
    private Beneficiario beneficiario;
    private Pagador pagador;
    private Banco banco;
    private Boleto boleto;
    private Cliente cliente;
    private ClienteDAO clienteDAO;

    /**
     * Obtém o boleto gerado.
     *
     * @return o boleto gerado
     */
    public Boleto getBoleto() {
        return boleto;
    }

    /**
     * Construtor da classe BoletoService.
     *
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados
     */
    public BoletoService() throws SQLException {

        this.banco = new BancoDoBrasil();
        this.clienteDAO = new ClienteDAO();
        this.cliente = StartCliente.getInstance().getCliente();
    }
    /**
     * Gera um boleto de pagamento com base nas informações fornecidas no DTO do boleto.
     *
     * @param boletoDTO o DTO do boleto contendo as informações necessárias
     * @return o boleto gerado
     */
    public Boleto gerarBoleto(BoletoDTO boletoDTO){

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
                .comDatas(setDatas(boletoDTO.getDataBoteto(),boletoDTO.getDataVencimentoBoleto()))
                .comBeneficiario(beneficiario)
                .comPagador(pagador)
                .comValorBoleto(boletoDTO.getValorBoleto())
                .comNumeroDoDocumento("1234")
                .comInstrucoes("Pagamento via App JalaBank")
                .comLocaisDePagamento("local 1", "local 2");
        return boleto;
    }
    /**
     * Gera o arquivo PDF do boleto.
     */
    public void gerarPDFBoleto(){
        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);
        gerador.geraPDF("Boleto_JalaBank.pdf");
    }

    /**
     * Define as datas do boleto.
     *
     * @param criacaoBoleto a data de criação do boleto
     * @param vencimentoBoleto a data de vencimento do boleto
     * @return as datas configuradas para o boleto
     */
    private Datas setDatas(LocalDate criacaoBoleto, LocalDate vencimentoBoleto){
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH) + 1;
        int ano = calendar.get(Calendar.YEAR);


        if (criacaoBoleto != null && vencimentoBoleto != null){
            return datas = Datas.novasDatas()
                    .comDocumento(criacaoBoleto.getDayOfMonth(), criacaoBoleto.getMonthValue(), criacaoBoleto.getYear())
                    .comProcessamento(dia, mes, ano)
                    .comVencimento(vencimentoBoleto.getDayOfMonth(), vencimentoBoleto.getMonthValue() , vencimentoBoleto.getYear());
        }
        return null;
    }
}
