package com.mycompany.unipar.central.model;

import com.mycompany.unipar.central.enums.TipoTransacaoEnum;
import java.sql.Date;

public class Transacao extends Conta {

    private int id;
    private String tipo;
    private Date data_hora;
    private double valor;
    private String ra;
    private String contaOrigem;
    private String contaDestino;
    private Conta conta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo(String tipo) {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
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

    public Conta getConta(Conta conta) {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
     private TipoTransacaoEnum tipoTransacao;
     
     public TipoTransacaoEnum getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacaoEnum tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
}
