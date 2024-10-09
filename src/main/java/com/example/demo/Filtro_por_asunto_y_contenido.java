package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

public class Filtro_por_asunto_y_contenido {
    
    private String criterioAsunto;
    private String criterioContenido;

    public Filtro_por_asunto_y_contenido(String criterioAsunto, String criterioContenido) {
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
