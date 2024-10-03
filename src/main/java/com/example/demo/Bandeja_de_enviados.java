package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Bandeja_de_enviados {

    private List<Correo> correos;

    public Bandeja_de_enviados() {
        this.correos = new ArrayList<>();
    }

    public void agregarCorreo(Correo correo) {
        correos.add(correo);
    }


    public int getcantidad() {
        return correos.size();
    }

    public List<Correo> getCorreos() {
        return correos;
    }

    public void enviarCorreo(Correo correo) {
        correos.add(correo);
    }

    public List<Correo> getBandejaDeEnviados() {
        return correos;
    }
}
