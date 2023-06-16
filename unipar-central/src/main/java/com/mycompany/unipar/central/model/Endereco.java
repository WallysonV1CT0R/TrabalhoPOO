package com.mycompany.unipar.central.model;

import java.sql.Date;

public class Endereco extends Pessoa {

    private int id;
    private String logradouro;
    private int numero;
    private String bairro;
    private String complemento;
    private int cep;
    private Pessoa pessoa;

    public Endereco(int id, String nome, int documento, String tipoPessoa, Date dataNasc) {
        super(id, nome, documento, tipoPessoa, dataNasc);
    }

    public Endereco() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", complemento=" + complemento + ", cep=" + cep + ", pessoa=" + pessoa + '}';
    }

}
