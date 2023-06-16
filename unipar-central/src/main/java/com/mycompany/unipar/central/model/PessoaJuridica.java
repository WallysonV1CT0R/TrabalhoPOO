package com.mycompany.unipar.central.model;

import com.mycompany.unipar.central.enums.TipoDocumentoEnum;
import java.sql.Date;

public class PessoaJuridica extends Pessoa{
    private String razaoSocial;
    private String cnpj;
    private String cnaePrincipal;
    private String fantasia;
    private Pessoa pessoa;
    private TipoDocumentoEnum tipoDocumento;
    private String numeroDocumento;

    public PessoaJuridica(String razaoSocial, String cnpj,
            String cnaePrincipal, String fantasia, Pessoa pessoa,
            int id, String nome, int documento,
            String tipoPessoa, Date dataNasc) {
        super(id, nome, documento, tipoPessoa, dataNasc);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cnaePrincipal = cnaePrincipal;
        this.fantasia = fantasia;
        this.pessoa = pessoa;
    }

    public PessoaJuridica(String razaoSocial,
            String cnpj, String cnaePrincipal, String fantasia, Pessoa pessoa) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cnaePrincipal = cnaePrincipal;
        this.fantasia = fantasia;
        this.pessoa = pessoa;
    }

    public PessoaJuridica() {
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

    public String getCnaePrincipal() {
        return cnaePrincipal;
    }

    public void setCnaePrincipal(String cnaePrincipal) {
        this.cnaePrincipal = cnaePrincipal;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + "razaoSocial=" + razaoSocial +
                ", cnpj=" + cnpj + ", cnaePrincipal=" + cnaePrincipal +
                ", fantasia=" + fantasia + ", pessoa=" + pessoa + '}';
    }
    
    

}
