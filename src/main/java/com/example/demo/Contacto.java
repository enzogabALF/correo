package com.example.demo;

public class Contacto {
    private String nombre;
    private String email;
    private Bandejas entrada;
    private Bandejas enviados;
    private Bandejas papelera;
    private Bandejas spam;

    public Contacto(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.entrada = setEntrada(entrada);
        this.enviados = setEnviados(enviados);
        this.papelera = setPapelera(papelera);
        this.spam = setSpam(spam);
    }
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    public Bandejas getEntrada() {
        return entrada;
    }
    public Bandejas getEnviados() {
        return enviados;
    }

    Bandejas setEntrada(Bandejas entrada) {
        return this.entrada = entrada;
    }
    
    private Bandejas setEnviados(Bandejas enviados) {
        return this.enviados = enviados;
    }
    Bandejas setSpam(Bandejas spam) {
        return this.spam = spam;
    }
    Bandejas setPapelera(Bandejas papelera) {
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
    
}
