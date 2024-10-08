package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Bandejas{

    private List<Correo> bandejaDeSpam = new ArrayList<>();

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
        return bandejaDeSpam;  
    }

    public List<Correo> getBandejaDeBorradores() {
        return correos;
    }

    public List<Correo> getBandejaDeArchivados() {
        return correos;
    }

    public void condicionDeSpam(Correo correo) {
        if (correo.getRemitente().getEmail().equals("null")) {  
            bandejaDeSpam.add(correo);  
        }
    }
    

    public void eliminarCorreo(List<Correo> bandeja, String remitente, String destinatario, String asunto) {
        bandeja.removeIf(correo -> correo.getRemitente().getEmail().equals(remitente)
            && correo.getDestinatarios().stream().anyMatch(c -> c.getEmail().equals(destinatario))
            && correo.getAsunto().equals(asunto));
    }
    
    public void moverACarpetaPapelera(List<Correo> bandeja, List<Correo> papelera, String remitente, String destinatario, String asunto) {
        Correo correo = bandeja.stream()
            .filter(c -> c.getRemitente().getEmail().equals(remitente)
                && c.getDestinatarios().stream().anyMatch(d -> d.getEmail().equals(destinatario))
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

    public Integer size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }
    
}
