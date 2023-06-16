package com.mycompany.unipar.central;

import com.mycompany.unipar.central.services.EstadoService;
import com.mycompany.unipar.central.*;
import com.mycompany.unipar.central.model.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UniparCentral {

    public static void main(String[] args) {
    try {
        EstadoService service =  new EstadoService();
        List<Estado> resultado = service.findAll();
        System.out.println(resultado.toString());
          
    } catch (Exception ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
        
    } 
}
}
