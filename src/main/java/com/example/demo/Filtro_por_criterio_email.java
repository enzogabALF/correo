package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

public class Filtro_por_criterio_email {
    
    private String criterio;

    public Filtro_por_criterio_email( String criterio) {
        
        this.criterio = criterio;
    }

   
    public List<Correo> aplicarFiltro(List<Correo> correos) {
        return correos.stream()
                .filter(correo -> correo.getRemitente().getEmail().contains(criterio)) 
                .collect(Collectors.toList());
    }
}
