
package com.mycompany.unipar.central.exceptions;

public class TamanhoCampoInvalidoException extends Exception{
    public TamanhoCampoInvalidoException(String campo, double tamanho){
        super ("O campo " + campo +"foi informado com tamanho (" + tamanho
                + " caracteres) " +  "invalido. Verifique!");
    }
    
}
