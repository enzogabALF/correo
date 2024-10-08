package com.example.demo;

import java.util.Iterator;

public class GestorCorreos {

    public void eliminarCorreo(Bandejas bandeja, Correo correo) {
        bandeja.removeCorreo(correo);
    }

    public void moverACarpetaPapelera(Bandejas bandeja, Bandejas papelera, Correo correo) {
        if (bandeja.getCorreos().remove(correo)) {
            papelera.addCorreo(correo);
        }
    }

    public void vaciarPapelera(Bandejas papelera) {
        papelera.clearCorreos();
    }


    public void moverSpamSinRemitente(Bandejas bandeja, Bandejas spam) {
        Iterator<Correo> iterator = bandeja.getCorreos().iterator();
        while (iterator.hasNext()) {
            Correo correo = iterator.next();
            Contacto remitente = correo.getRemitente();
            if (remitente == null || remitente.getEmail().trim().isEmpty()) {
                spam.addCorreo(correo);
                iterator.remove();
            }
        }
    }
}

