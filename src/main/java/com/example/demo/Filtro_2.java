package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Filtro_2 {
    
    private String nombre;
    private List<String> criterios;

    public Filtro_2(String nombre, List<String> criterios) {
        this.nombre = nombre;
        this.criterios = criterios;
    }

    public List<Correo> aplicarFiltro(List<Correo> correos) {
        List<Correo> resultado = new ArrayList<>();
        for (Correo correo : correos) {
            boolean cumpleCriterios = true;
            for (String criterio : criterios) {
                if (!correo.getAsunto().contains(criterio) && 
                    !correo.getContenido().contains(criterio) &&
                    !correo.getRemitente().getEmail().contains(criterio)) {
                    cumpleCriterios = false;
                    break;
                }
            }
            if (cumpleCriterios) {
                resultado.add(correo);
            }
        }
        return resultado;
    }
}

