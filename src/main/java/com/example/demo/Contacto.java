package com.example.demo;

public class Contacto {
    private String nombre;
// Suggested code may be subject to a license. Learn more: ~LicenseLog:3625515783.
// Suggested code may be subject to a license. Learn more: ~LicenseLog:1813818837.
    private String email;

    public Contacto(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
