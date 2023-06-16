
package com.mycompany.unipar.central.model;


public class Cidade extends Estado{
    private int id;
    private String nome;
    private String ra;
    private Estado estado;

    

    public Cidade(int id, String nome, String sigla, Pais pais) {
        super(id, nome, sigla, pais);
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cidade{" + "id=" + id + ", nome=" + nome +
                ", ra=" + ra + ", estado=" + estado + '}';
    }
    
    
}
