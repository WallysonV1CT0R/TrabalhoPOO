package com.mycompany.unipar.central.enums;

import com.mycompany.unipar.central.model.Telefone;

public enum OperadoraEnum{
    VIVO(15),
    TIM(41),
    CLARO(21),
    OI(31);
    

    private final int codArea;

    private OperadoraEnum(int codArea) {
        this.codArea = codArea;
    }

    public int getCodigo() {
        return codArea;
    }
}
