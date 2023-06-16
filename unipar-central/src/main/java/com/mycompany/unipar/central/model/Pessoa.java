package com.mycompany.unipar.central.model;

import java.util.ArrayList;
import java.sql.Date;



public class Pessoa {
    private int id;
    private String nome;
    private int documento;
    private String tipoPessoa;
    private Date dataNasc;
    private ArrayList<Endereco> enderecos = new ArrayList<>();
    private ArrayList<Telefone> telefones = new ArrayList<>();

    public Pessoa(int id, String nome,
            int documento, String tipoPessoa, Date dataNasc) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.tipoPessoa = tipoPessoa;
        this.dataNasc = dataNasc;
        this.telefones = telefones;
        this.enderecos= enderecos;
    }

    public Pessoa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome +
                ", documento=" + documento + ", tipoPessoa=" +
                tipoPessoa + ", dataNasc=" + dataNasc + '}';
    }
    
}
