package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Filtro_2 {

    private String nombre;
    private List<String> criterios;
    private boolean incluir;  

    public Filtro_2(String nombre, List<String> criterios, boolean incluir) {
        this.nombre = nombre;
        this.criterios = criterios;
        this.incluir = incluir;
    }

    public List<Correo> aplicarFiltro(List<Correo> correos) {
        List<Correo> resultado = new ArrayList<>();
        for (Correo correo : correos) {
            boolean cumpleCriterios = false;

            
            for (String criterio : criterios) {
                if (correo.getAsunto().contains(criterio) || 
                    correo.getContenido().contains(criterio) ||
                    correo.getRemitente().getEmail().contains(criterio)) {
                    cumpleCriterios = true;  // Si alguno coincide, lo marcamos
                    break;  // Salimos del bucle si encontramos un criterio coincidente
                }
            }
            if ((incluir && cumpleCriterios) || (!incluir && !cumpleCriterios)) {
                resultado.add(correo);
            }
        }
        return resultado;
    }
}


