package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroPorRemitenteNombre {
    
    private String nombre;

    public FiltroPorRemitenteNombre( String nombre) {
        
        this.nombre = nombre;
    }

    public List<Correo> aplicarFiltro(List<Correo> correos) {
        return correos.stream()
                .filter(correo -> correo.getRemitente().getNombre().contains(nombre)) 
                .collect(Collectors.toList());
    }
}
