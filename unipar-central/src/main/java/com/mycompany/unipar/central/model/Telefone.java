
package com.mycompany.unipar.central.model;

import com.mycompany.unipar.central.enums.OperadoraEnum;


public class Telefone{
    private int id;
    private String numero;
    private String operadora;

    public Telefone() {
    }

    public Telefone(int id, String numero, String operadora) {
        this.id = id;
        this.numero = numero;
        this.operadora = operadora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }
    
}
