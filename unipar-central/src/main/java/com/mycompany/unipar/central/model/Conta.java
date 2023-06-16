package com.mycompany.unipar.central.model;

import com.mycompany.unipar.central.enums.TipoContaEnum;

public class Conta extends Banco {

    private int id;
    private String conta;
    private String agencia;
    private String digito;
    private int tipo;
    private double saldo;
    private String ra;
    private Banco banco;
    private TipoContaEnum tipoConta;

    public Conta(String conta, String agencia, String digito, int tipo,
            double saldo, Banco banco, int id, String nome, String ra) {
        super(id, nome, ra);
        this.conta = conta;
        this.agencia = agencia;
        this.digito = digito;
        this.tipo = tipo;
        this.saldo = saldo;
        this.banco = banco;
    }

    public Conta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
    public TipoContaEnum getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaEnum tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public String toString() {
        return "Conta{" + "id=" + id + ", conta=" + conta +
                ", agencia=" + agencia + ", digito=" + digito +
                ", tipo=" + tipo + ", saldo=" + saldo + ", ra=" +
                ra + ", banco=" + banco + '}';
    }

}
