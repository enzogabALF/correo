package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CorreoTest {

    @Test
    public void Creacion_de_un_correo(){

        Contacto remitente = new Contacto("Enzo Alfonso", "Enzo_alfonso@gmail.com");
        Contacto destinatario = new Contacto("Carla Martinez", "carla_mart@gmail.com");

        Correo correo = new Correo("asunto", "contenido", remitente, destinatario);

        assertEquals("asunto", correo.getasunto());
        assertEquals("contenido", correo.getcontenido());
        assertEquals(remitente, correo.getremitente());
        assertEquals(destinatario, correo.getdestinatario());
    }


    @Test
    public void Creacion_de_correo_sin_asunto(){

        Contacto remitente = new Contacto("Enzo Alfonso", "Enzo_alfonso@gmail.com");
        Contacto destinatario = new Contacto("Carla Martinez", "carla_mart@gmail.com");

        Correo correo = new Correo("", "contenido", remitente, destinatario);

        assertEquals("", correo.getasunto());
        assertEquals("contenido", correo.getcontenido());
        assertEquals(remitente, correo.getremitente());
        assertEquals(destinatario, correo.getdestinatario());

    }

    @Test
    public void Creacion_de_correo_sin_Contacto(){

        Contacto remitente = new Contacto("Enzo Alfonso", "Enzo_alfonso@gmail.com");
        Contacto destinatario = new Contacto("", "");

        Correo correo = new Correo("asunto", "contenido", remitente, destinatario);

        assertEquals("asunto", correo.getasunto());
        assertEquals("contenido", correo.getcontenido());
        assertEquals(remitente, correo.getremitente());
        assertNotEquals(null, correo.getdestinatario()); //revisar :v

    }
    
}
