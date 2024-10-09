package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

public class Filtro_por_nombre {
    
    private String nombre;

    public Filtro_por_nombre( String nombre) {
        
        this.nombre = nombre;
    }

   
    public List<Correo> aplicarFiltro(List<Correo> correos) {
        return correos.stream()
                .filter(correo -> correo.getRemitente().getEmail().contains(nombre)) 
                .collect(Collectors.toList());
    }
}
