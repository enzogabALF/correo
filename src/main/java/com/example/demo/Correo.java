package com.example.demo;
//import java.util.List;

public class Correo {

private String asunto;
private String contenido;
private Contacto remitente;
private Contacto destinatario;

//private List<Contacto> destinatarios; revisar :v

public Correo(String asunto, String contenido, Contacto remitente, Contacto destinatario) {
    this.asunto = asunto;
    this.contenido = contenido;
    this.remitente = remitente;
    this.destinatario = destinatario;
}
/* 
public String setasunto() {
    return asunto;
}

public String setcontenido() {
    return contenido;
}

public Contacto setremitente() {
    return remitente;
}

public Contacto setdestinatario() {
    return destinatario;
}

public List<Contacto> setdestinatarios() {
    return destinatarios;
}
*/
public String getasunto(){
    return asunto;
}

public String getcontenido(){
    return contenido;
}

public Contacto getremitente(){
    return remitente;
}

public Contacto getdestinatario(){
    return destinatario;
}

/*
public List<Contacto> getdestinatarios(){
    return destinatarios;
}

 */





    
}
