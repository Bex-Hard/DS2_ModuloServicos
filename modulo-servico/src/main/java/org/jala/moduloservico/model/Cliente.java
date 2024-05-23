package org.jala.moduloservico.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private List<ContaCorrente> contasCorrentes;
    private List<ContaPoupanca> contasPoupanca;
    private List<CartaoCredito> cartoesDeCredito;
    private String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

    public Cliente() {
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.contasCorrentes = new ArrayList<>();
        this.contasPoupanca = new ArrayList<>();
        this.cartoesDeCredito = new ArrayList<>();
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setContasCorrentes(List<ContaCorrente> contasCorrentes) {
        this.contasCorrentes = contasCorrentes;
    }

    public void setContasPoupanca(List<ContaPoupanca> contasPoupanca) {
        this.contasPoupanca = contasPoupanca;
    }

    public void setCartoesDeCredito(List<CartaoCredito> cartoesDeCredito) {
        this.cartoesDeCredito = cartoesDeCredito;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void adicionarContaCorrente(ContaCorrente conta) {
        contasCorrentes.add(conta);
    }

    public void adicionarContaPoupanca(ContaPoupanca conta) {
        contasPoupanca.add(conta);
    }

    public void adicionarCartaoDeCredito(CartaoCredito cartao) {
        cartoesDeCredito.add(cartao);
    }

    public List<ContaCorrente> getContasCorrentes() {
        return contasCorrentes;
    }

    public List<ContaPoupanca> getContasPoupanca() {
        return contasPoupanca;
    }

    public List<CartaoCredito> getCartoesDeCredito() {
        return cartoesDeCredito;
    }
}