package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroPorAsuntoYContenido {
    
    private String criterioAsunto;
    private String criterioContenido;

    public FiltroPorAsuntoYContenido(String criterioAsunto, String criterioContenido) {
        this.criterioAsunto = criterioAsunto;
        this.criterioContenido = criterioContenido;
    }

    public List<Correo> aplicarFiltro(List<Correo> correos) {
        return correos.stream()
                .filter(correo -> correo.getAsunto().contains(criterioAsunto) &&
                                  correo.getContenido().contains(criterioContenido))
                .collect(Collectors.toList());
    }


}
