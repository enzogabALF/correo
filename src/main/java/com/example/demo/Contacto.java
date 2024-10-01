package com.example.demo;

public class Contacto {
    private String nombre;
    private String email;

    public Contacto(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }

}
