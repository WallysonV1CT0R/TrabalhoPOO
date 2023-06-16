package com.mycompany.unipar.central.model;

import com.mycompany.unipar.central.enums.TipoDocumentoEnum;
import java.sql.Date;

public class PessoaFisica extends Pessoa {

    private String nome;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private Pessoa pessoa;
    private TipoDocumentoEnum tipoDocumento;
    private String numeroDocumento;

    public PessoaFisica(String cpf, String rg, Date dataNascimento,
            Pessoa pessoa, int id, String nome, int documento,
            String tipoPessoa, Date dataNasc) {
        super(id, nome, documento, tipoPessoa, dataNasc);
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.pessoa = pessoa;
    }

    public PessoaFisica(String nome, String cpf, String rg,
            Date dataNascimento, Pessoa pessoa) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.pessoa = pessoa;
    }

    public PessoaFisica() {
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
