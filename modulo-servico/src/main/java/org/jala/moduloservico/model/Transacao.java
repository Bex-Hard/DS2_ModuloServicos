    package org.jala.moduloservico.model;
    import java.time.LocalDateTime;

    public class Transacao {
        // Dados do Cliente
        private String nomeCliente;
        private String numeroConta;
        private String cpfCnpj;
        private String dadosContato;

        // Dados da Transação
        private String idTransacao;
        private String tipoTransacao;
        private double valor;
        private LocalDateTime dataHoraTransacao;
        private String moeda;

        // Dados das Contas Envolvidas
        private String contaOrigem;
        private String contaDestino;
        private String bancoOrigem;
        private String bancoDestino;

        // Método de Transação
        private String instrumentoPagamento;
        private String numeroCartao;

        // Descrição e Finalidade
        private String descricao;
        private String categoria;

        // Confirmações e Comprovantes
        private String confirmacao;

        // Construtor
        public Transacao(String nomeCliente, String numeroConta, String cpfCnpj, String dadosContato,
                         String idTransacao, String tipoTransacao, double valor, LocalDateTime dataHoraTransacao,
                         String moeda, String contaOrigem, String contaDestino,
                         String bancoOrigem, String bancoDestino, String instrumentoPagamento, String numeroCartao, String descricao, String categoria,
                         String confirmacao) {
            this.nomeCliente = nomeCliente;
            this.numeroConta = numeroConta;
            this.cpfCnpj = cpfCnpj;
            this.dadosContato = dadosContato;
            this.idTransacao = idTransacao;
            this.tipoTransacao = tipoTransacao;
            this.valor = valor;
            this.dataHoraTransacao = dataHoraTransacao;
            this.moeda = moeda;
            this.contaOrigem = contaOrigem;
            this.contaDestino = contaDestino;
            this.bancoOrigem = bancoOrigem;
            this.bancoDestino = bancoDestino;
            this.instrumentoPagamento = instrumentoPagamento;
            this.numeroCartao = numeroCartao;
            this.descricao = descricao;
            this.categoria = categoria;
            this.confirmacao = confirmacao;
        }

        // Getters e Setters
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

        public String getDadosContato() {
            return dadosContato;
        }

        public void setDadosContato(String dadosContato) {
            this.dadosContato = dadosContato;
        }

        public String getIdTransacao() {
            return idTransacao;
        }

        public void setIdTransacao(String idTransacao) {
            this.idTransacao = idTransacao;
        }

        public String getTipoTransacao() {
            return tipoTransacao;
        }

        public void setTipoTransacao(String tipoTransacao) {
            this.tipoTransacao = tipoTransacao;
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

        public String getBancoOrigem() {
            return bancoOrigem;
        }

        public void setBancoOrigem(String bancoOrigem) {
            this.bancoOrigem = bancoOrigem;
        }

        public String getBancoDestino() {
            return bancoDestino;
        }

        public void setBancoDestino(String bancoDestino) {
            this.bancoDestino = bancoDestino;
        }

        public String getInstrumentoPagamento() {
            return instrumentoPagamento;
        }

        public void setInstrumentoPagamento(String instrumentoPagamento) {
            this.instrumentoPagamento = instrumentoPagamento;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public String getConfirmacao() {
            return confirmacao;
        }

        public void setConfirmacao(String confirmacao) {
            this.confirmacao = confirmacao;
        }

        public String getNumeroCartao() {
            return numeroCartao;
        }

        public void setNumeroCartao(String numeroCartao) {
            this.numeroCartao = numeroCartao;
        }

        @Override
        public String toString() {
            return "Transacao{" +
                    "nomeCliente='" + nomeCliente + '\'' +
                    ", numeroConta='" + numeroConta + '\'' +
                    ", cpfCnpj='" + cpfCnpj + '\'' +
                    ", dadosContato='" + dadosContato + '\'' +
                    ", idTransacao='" + idTransacao + '\'' +
                    ", tipoTransacao='" + tipoTransacao + '\'' +
                    ", valor=" + valor +
                    ", dataHoraTransacao=" + dataHoraTransacao +
                    ", moeda='" + moeda + '\'' +
                    ", contaOrigem='" + contaOrigem + '\'' +
                    ", contaDestino='" + contaDestino + '\'' +
                    ", bancoOrigem='" + bancoOrigem + '\'' +
                    ", bancoDestino='" + bancoDestino + '\'' +
                    ", instrumentoPagamento='" + instrumentoPagamento + '\'' +
                    ", numeroCartao='" + numeroCartao + '\'' +
                    ", descricao='" + descricao + '\'' +
                    ", categoria='" + categoria + '\'' +
                    ", confirmacao='" + confirmacao + '\'' +
                    '}';
        }
    }
