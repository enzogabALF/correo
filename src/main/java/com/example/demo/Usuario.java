package com.example.demo;

public class Usuario extends Contacto {


    public Usuario(String nombre, String email) {
        super(nombre, email);
    }
    public void enviarCorreo(Bandejas gestor, Correo correo) {
        gestor.enviarCorreo(correo);
    }
    
}
