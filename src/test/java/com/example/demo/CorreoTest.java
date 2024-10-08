package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CorreoTest {

    @Test
    public void Creacion_de_un_correo_test() {
        Contacto remitente = new Contacto("Enzo Alfonso", "Enzo_alfonso@gmail.com");
        Contacto destinatario1 = new Contacto("Carla Martinez", "carla_mart@gmail.com");
        List<Contacto> destinatarios = Arrays.asList(destinatario1);        
        Correo correo = new Correo("asunto", "contenido", remitente, destinatarios);
        remitente.setEnviados(new Bandejas());
        destinatario1.setEntrada(new Bandejas());
        assertEquals("asunto", correo.getAsunto());
        assertEquals("contenido", correo.getContenido());
        assertEquals(remitente, correo.getRemitente());
        assertEquals(1, correo.getDestinatarios().size());
        assertEquals(destinatario1, correo.getDestinatarios().get(0));
    }

    @Test
    public void Creacion_de_correo_sin_asunto_tets() {
        Contacto remitente = new Contacto("Enzo Alfonso", "Enzo_alfonso@gmail.com");
        Contacto destinatario1 = new Contacto("Carla Martinez", "carla_mart@gmail.com");

        
        List<Contacto> destinatarios = Arrays.asList(destinatario1);
        
        Correo correo = new Correo("", "contenido", remitente, destinatarios);

        assertEquals("", correo.getAsunto());
        assertEquals("contenido", correo.getContenido());
        assertEquals(remitente, correo.getRemitente());
        
        
        assertEquals(1, correo.getDestinatarios().size());
        assertEquals(destinatario1, correo.getDestinatarios().get(0));
    }

    @Test
    public void Creacion_de_correo_con_destinatario_sin_informacion_tets() {
        Contacto remitente = new Contacto("Enzo Alfonso", "Enzo_alfonso@gmail.com");
        Contacto destinatario1 = new Contacto("", "");   //datos vacio para este caso :v

        
        List<Contacto> destinatarios = Arrays.asList(destinatario1);
        
        Correo correo = new Correo("asunto", "contenido", remitente, destinatarios);
        remitente.setEnviados(new Bandejas());
        destinatario1.setEntrada(new Bandejas());
        //remitente.getEnviados()= add.addCorreo(correo);
        //destinatario1.getEntrada()= add.addCorreo(correo);
        assertEquals("asunto", correo.getAsunto());
        assertEquals("contenido", correo.getContenido());
        assertEquals(remitente, correo.getRemitente());
        
       
        assertEquals(1, correo.getDestinatarios().size());
        assertEquals(destinatario1, correo.getDestinatarios().get(0));
        assertNotEquals(null, correo.getDestinatarios().get(0)); 
    }


    @Test
        public void Crear_correo_con_multiples_destinatarios_test() {
        Contacto remitente = new Contacto("Juan Perez", "juan.perez@example.com");
        Contacto destinatario1 = new Contacto("Maria Lopez", "maria.lopez@example.com");
        Contacto destinatario2 = new Contacto("Carlos Gomez", "carlos.gomez@example.com");

        List<Contacto> destinatarios = Arrays.asList(destinatario1, destinatario2);

        Correo correo = new Correo("Asunto", "Contenido", remitente, destinatarios);

        assertEquals("Asunto", correo.getAsunto());
        assertEquals("Contenido", correo.getContenido());
        assertEquals(remitente, correo.getRemitente());
        assertEquals(2, correo.getDestinatarios().size());
        assertEquals(destinatario1, correo.getDestinatarios().get(0));
        assertEquals(destinatario2, correo.getDestinatarios().get(1));
    }

    @Test
    public void Enviar_correo_con_multiples_Destinatarios_test() {
        Bandejas gestor = new Bandejas();
        Contacto remitente = new Contacto("Juan Perez", "juan.perez@example.com");
        Contacto destinatario1 = new Contacto("Maria Lopez", "maria.lopez@example.com");
        Contacto destinatario2 = new Contacto("Carlos Gomez", "carlos.gomez@example.com");

        List<Contacto> destinatarios = Arrays.asList(destinatario1, destinatario2);
        Correo correo = new Correo("Asunto", "Contenido", remitente, destinatarios);

        gestor.enviarCorreo(correo);

        assertEquals(1, gestor.getBandejaDeEnviados().size());
        assertEquals(correo, gestor.getBandejaDeEnviados().get(0));
    }  
}
