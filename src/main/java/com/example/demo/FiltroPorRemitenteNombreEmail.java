package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroPorRemitenteNombreEmail {
    private String nombre;
    private String criterio;

    public FiltroPorRemitenteNombreEmail(String nombre, String criterio) {
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