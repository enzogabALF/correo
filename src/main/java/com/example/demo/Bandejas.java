package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Bandejas {

    private List<Correo> correos;

    public Bandejas() {
        this.correos = new ArrayList<>();
    }

    public void enviarCorreo(Correo correo) {
        correos.add(correo);
    }

    public List<Correo> getBandejaDeEnviados() {
        return correos;
    }

    public List<Correo> getBandejaDeRecibidos() {
        return correos;
    }

    public List<Correo> getBandejaDeSpam() {
        return correos;
    }

    public List<Correo> getBandejaDeBorradores() {
        return correos;
    }

    
}
