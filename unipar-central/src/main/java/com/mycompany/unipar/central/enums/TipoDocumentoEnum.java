package com.mycompany.unipar.central.enums;

public enum TipoDocumentoEnum {
    CPF("CPF"),
    RG("RG"),
    CNPJ("CNPJ"),
    PASSAPORTE("Passaporte");

    private final String descricao;

    TipoDocumentoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

