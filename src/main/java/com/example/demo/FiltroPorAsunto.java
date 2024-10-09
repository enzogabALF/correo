package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroPorAsunto {
    
    private String criterioAsunto;
    

    public FiltroPorAsunto(String criterioAsunto) {
        this.criterioAsunto = criterioAsunto;
        
    }

    public List<Correo> aplicarFiltro(List<Correo> correos) {
        return correos.stream()
                .filter(correo -> correo.getAsunto().contains(criterioAsunto))
                .collect(Collectors.toList());
    }



}
