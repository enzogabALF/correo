package com.example.demo;

public class Contacto {
    private String nombre;
    private String email;
    private Bandejas entrada;
    private Bandejas enviados;
    private Bandejas papelera;
    private Bandejas spam;

    public Contacto(String nombre, String email, Bandejas entrada, Bandejas enviados, Bandejas papelera, Bandejas spam) {
        this.nombre = nombre;
        this.email = email;
        this.entrada = setEntrada(entrada);
        this.enviados = setEnviados(enviados);
        this.papelera = setPapelera(papelera);
        this.spam = setSpam(spam);
    }
    

    private Bandejas setEntrada(Bandejas entrada) {
        return this.entrada = entrada;
    }
    
    private Bandejas setEnviados(Bandejas enviados) {
        return this.enviados = enviados;
    }
    private Bandejas setSpam(Bandejas spam) {
        return this.spam = spam;
    }
    private Bandejas setPapelera(Bandejas papelera) {
        return this.papelera = papelera;
    }


    public Bandejas getBandejaEntrada() {
        return entrada;
    }

    public Bandejas getBandejaEnviado() {
        return enviados;
    }

    public Bandejas getBandejaSpam() {
        return spam;
    }

    public Bandejas getBandejaPapelera() {
        return papelera;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }


    public void setBandejaEntrada(Bandejas entrada) {
        this.entrada = entrada;
    }

    
    public void enviarCorreo(Correo correo) {
        // Añadir el correo a la bandeja de enviados del remitente
        correo.getRemitente().getBandejaEnviado().addCorreo(correo);
    }

    public void recibirCorreo(Correo correo) {
        // Añadir el correo a la bandeja de entrada del destinatario
        correo.getDestinatarios().forEach(destinatario -> destinatario.getBandejaEntrada().addCorreo(correo));
    }
}