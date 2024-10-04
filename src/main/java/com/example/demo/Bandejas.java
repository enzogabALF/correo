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

    public List<Correo> getBandejaDeArchivados() {
        return correos;
    }

    public void condicionDeSpam(Correo correo) {

        if(correo.getEmail()=="null"){
            getBandejaDeSpam();
        }
    


    }

    public void eliminarCorreo(List<Correo> bandeja, String remitente, String destinatario, String asunto) {
        bandeja.removeIf(correo -> correo.getRemitente().equals(remitente)
            && correo.getDestinatario().equals(destinatario)
            && correo.getAsunto().equals(asunto));
    }
    
    public void moverACarpetaPapelera(List<Correo> bandeja, List<Correo> papelera, String remitente, String destinatario, String asunto) {
        Correo correo = bandeja.stream()
            .filter(c -> c.getRemitente().equals(remitente)
                && c.getDestinatario().equals(destinatario)
                && c.getAsunto().equals(asunto))
            .findFirst().orElse(null);
        if (correo != null) {
            papelera.add(correo);
            eliminarCorreo(bandeja, remitente, destinatario, asunto);
        }
    }
    public void vaciarPapelera(List<Correo> papelera) {
        papelera.clear();
    }
    
    
}
