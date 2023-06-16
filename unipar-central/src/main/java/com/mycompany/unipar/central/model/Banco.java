package com.mycompany.unipar.central.model;

public class Banco {
    private int id;
    private String nome;
    private String ra;

    public Banco(int id, String nome, String ra) {
        this.id = id;
        this.nome = nome;
        this.ra = ra;
    }

    public Banco() {
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

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "Banco{" + "id=" + id + ", nome=" + nome + ", ra=" + ra + '}';
    }
    
}
