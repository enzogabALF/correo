package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

public class Filtro_por_asunto {
    
    private String criterioAsunto;
    

    public Filtro_por_asunto(String criterioAsunto) {
        this.criterioAsunto = criterioAsunto;
        
    }

    public List<Correo> aplicarFiltro(List<Correo> correos) {
        return correos.stream()
                .filter(correo -> correo.getAsunto().contains(criterioAsunto))
                .collect(Collectors.toList());
    }



}
