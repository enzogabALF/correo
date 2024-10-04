package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

public class Filtro {
    private String nombre;
    private String criterio;

    public Filtro(String nombre, String criterio) {
        this.nombre = nombre;
        this.criterio = criterio;
    }

   
    public List<Correo> aplicarFiltro(List<Correo> correos) {
        return correos.stream()
                .filter(correo -> correo.getRemitente().getEmail().contains(criterio)) 
                .collect(Collectors.toList());
    }
}

