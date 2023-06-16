package com.mycompany.unipar.central.model;

public class Agencia extends Conta{

    private int id;
    private String codigo;
    private String razaoSocial;
    private String cnpj;
    private String ra;
    private Conta conta;

    public Agencia(int id, String codigo, String razaoSocial, String cnpj, String ra, Conta conta) {
        super(cnpj, ra, codigo, id, id, conta, id, ra, ra);
        this.id = id;
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.ra = ra;
        this.conta = conta;
    }

    public Agencia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "Agencia{" + "id=" + id + ", codigo=" + codigo +
                ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj +
                ", ra=" + ra + ", conta=" + conta + '}';
    }

}
