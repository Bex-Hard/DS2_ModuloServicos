    package org.jala.moduloservico.model;
    import org.jala.moduloservico.model.enums.TipoServicos;
    import org.jala.moduloservico.model.enums.TipoPagamento;

    import java.time.LocalDateTime;

    public class Transacao {

        private long idUser;
        private String idTransacao;

        // Dados do Cliente
        private String nomeCliente;
        private String numeroConta;
        private String cpfCnpj;
        private String emailCliente;

        // Dados da Transação
        private TipoPagamento tipoPagamento;
        private double valor;
        private LocalDateTime dataHoraTransacao;
        private String moeda = "R$";

        // Dados das Contas Envolvidas
        private String contaOrigem;
        private String contaDestino;

        // Método de Transação
        private TipoServicos tipoServico;
        private String numeroCartao;

        // Descrição e Finalidade
        private String descricao;

        // Confirmações e Comprovantes
        private Boolean confirmacao = false;

        public Transacao() {
        }

        // Construtor
        public Transacao(Long idUser, String nomeCliente, String numeroConta, String cpfCnpj, String emailCliente,
                         String idTransacao, TipoPagamento tipoPagamento, double valor, LocalDateTime dataHoraTransacao,
                         String moeda, String contaOrigem, String contaDestino,
                         TipoServicos tipoServico, String numeroCartao, String descricao,
                         Boolean confirmacao) {

            this.idUser = idUser;
            this.nomeCliente = nomeCliente;
            this.numeroConta = numeroConta;
            this.cpfCnpj = cpfCnpj;
            this.emailCliente = emailCliente;
            this.idTransacao = idTransacao;
            this.valor = valor;
            this.dataHoraTransacao = dataHoraTransacao;
            this.moeda = moeda;
            this.contaOrigem = contaOrigem;
            this.contaDestino = contaDestino;
            this.tipoServico = tipoServico;
            this.numeroCartao = numeroCartao;
            this.descricao = descricao;

            this.confirmacao = confirmacao;
            this.tipoPagamento = tipoPagamento;
        }

        // Getters e Setters

        public long getIdUser() {
            return idUser;
        }

        public void setIdUser(long idUser) {
            this.idUser = idUser;
        }

        public String getNomeCliente() {
            return nomeCliente;
        }

        public void setNomeCliente(String nomeCliente) {
            this.nomeCliente = nomeCliente;
        }

        public String getNumeroConta() {
            return numeroConta;
        }

        public void setNumeroConta(String numeroConta) {
            this.numeroConta = numeroConta;
        }

        public String getCpfCnpj() {
            return cpfCnpj;
        }

        public void setCpfCnpj(String cpfCnpj) {
            this.cpfCnpj = cpfCnpj;
        }

        public String getEmailCliente() {
            return emailCliente;
        }

        public void setEmailCliente(String emailCliente) {
            this.emailCliente = emailCliente;
        }

        public String getIdTransacao() {
            return idTransacao;
        }

        public void setIdTransacao(String idTransacao) {
            this.idTransacao = idTransacao;
        }



        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public LocalDateTime getDataHoraTransacao() {
            return dataHoraTransacao;
        }

        public void setDataHoraTransacao(LocalDateTime dataHoraTransacao) {
            this.dataHoraTransacao = dataHoraTransacao;
        }

        public String getMoeda() {
            return moeda;
        }

        public void setMoeda(String moeda) {
            this.moeda = moeda;
        }

        public String getContaOrigem() {
            return contaOrigem;
        }

        public void setContaOrigem(String contaOrigem) {
            this.contaOrigem = contaOrigem;
        }

        public String getContaDestino() {
            return contaDestino;
        }

        public void setContaDestino(String contaDestino) {
            this.contaDestino = contaDestino;
        }


        public TipoPagamento getTipoPagamento() {
            return tipoPagamento;
        }

        public void setTipoPagamento(TipoPagamento tipoPagamento) {
            this.tipoPagamento = tipoPagamento;
        }

        public TipoServicos getTipoServico() {
            return tipoServico;
        }

        public void setTipoServico(TipoServicos tipoServico) {
            this.tipoServico = tipoServico;
        }

        public Boolean getConfirmacao() {
            return confirmacao;
        }

        public void setConfirmacao(Boolean confirmacao) {
            this.confirmacao = confirmacao;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }



        public String getNumeroCartao() {
            return numeroCartao;
        }

        public void setNumeroCartao(String numeroCartao) {
            this.numeroCartao = numeroCartao;
        }


    }
