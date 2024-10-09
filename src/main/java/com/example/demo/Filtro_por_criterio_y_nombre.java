package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

public class Filtro_por_criterio_y_nombre {
    private String nombre;
    private String criterio;

    public Filtro_por_criterio_y_nombre(String nombre, String criterio) {
        this.nombre = nombre;
        this.criterio = criterio;
    }

   
    public List<Correo> aplicarFiltro(List<Correo> correos) {
        return correos.stream()
                .filter(correo -> correo.getRemitente().getEmail().contains(criterio) &&
                correo.getRemitente().getNombre().contains(nombre))
                .collect(Collectors.toList());
    }
}