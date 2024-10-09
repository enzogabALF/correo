package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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
        assertEquals(destinatarios, correo.getDestinatarios());
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
        remitente.getEnviados();
        destinatario1.setEntrada(destinatario1.getBandejaEntrada());
        //Bandejas add = new Bandejas();
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
    public void testEnviarCorreoConMultiplesDestinatarios() {
        // Crear contactos
        Contacto remitente = new Contacto("Juan", "juan@example.com");
        Contacto destinatario1 = new Contacto("Ana", "ana@example.com");
        Contacto destinatario2 = new Contacto("Carlos", "carlos@example.com");

        // Crear lista de destinatarios
        List<Contacto> destinatarios = Arrays.asList(destinatario1, destinatario2);
     

        // Crear correo
        Correo correo = new Correo("Asunto Importante", "Contenido del correo", remitente, destinatarios);

        // Crear bandeja del remitente
        Bandejas bandejasRemitente = remitente.getEnviados();

        // Enviar correo
        GestorCorreos bandejas = new GestorCorreos();
        bandejas.enviarCorreo(correo);

        // Verificar que el correo fue añadido a la bandeja de enviados del remitente
        assertTrue(bandejasRemitente.getCorreos().contains(correo));

        // Verificar que el correo fue añadido a la bandeja de entrada de cada destinatario
        assertTrue(destinatario1.getBandejaEntrada().getCorreos().contains(correo));
        
    }
    
    @Test
    public void testAddCorreo() {
        Bandejas bandejas = new Bandejas();
        Contacto contacto = new Contacto("Juan", "juan@example.com");
        
        Contacto destinatario1= new Contacto("Ana", "ana@example.com");
        List<Contacto> destinatarios =  Arrays.asList(destinatario1);
        Correo correo1 = new Correo("Asunto 1", "Contenido 1", contacto, destinatarios);
        bandejas.addCorreo(correo1);
        assertEquals(1, bandejas.getCorreos().size());
        assertTrue(bandejas.getCorreos().contains(correo1));
    }

    @Test
    public void testRemoveCorreo() {
        Bandejas bandejas = new Bandejas();
        Contacto contacto = new Contacto("Juan", "juan@example.com");
        
        Contacto destinatario1= new Contacto("Ana", "ana@example.com");
        List<Contacto> destinatarios = Arrays.asList(destinatario1);
        Correo correo1 = new Correo("Asunto 1", "Contenido 1", contacto, destinatarios);
        bandejas.addCorreo(correo1);
        bandejas.removeCorreo(correo1);
        assertFalse(bandejas.getCorreos().contains(correo1));
    }

    @Test
    public void testClearCorreos() {
        Bandejas bandejas = new Bandejas();
        Contacto contacto = new Contacto("Juan", "juan@example.com");
        
        Contacto destinatario= new Contacto("Ana", "ana@example.com");
        List<Contacto> destinatarios =  Arrays.asList(destinatario);
        Correo correo1 = new Correo("Asunto 1", "Contenido 1", contacto, destinatarios);
        Correo correo2 = new Correo("Asunto 2", "Contenido 2", contacto, destinatarios);
        bandejas.addCorreo(correo1);
        bandejas.addCorreo(correo2);
        bandejas.clearCorreos();
        assertTrue(bandejas.getCorreos().isEmpty());
    }

    @Test
    public void testGetCorreos() {
        Bandejas bandejas = new Bandejas();
        Contacto contacto = new Contacto("Juan", "juan@example.com");
        
        Contacto destinatario= new Contacto("Ana", "ana@example.com");
        List<Contacto> destinatarios =  Arrays.asList(destinatario);
        Correo correo1 = new Correo("Asunto 1", "Contenido 1", contacto, destinatarios);
        Correo correo2 = new Correo("Asunto 2", "Contenido 2", contacto, destinatarios);
        List<Correo> correos = new ArrayList<>();
        correos.add(correo1);
        correos.add(correo1);
        correos.add(correo2);
        bandejas.addCorreo(correo1);
        bandejas.addCorreo(correo2);
        assertTrue(bandejas.getCorreos().contains(correo2));
        assertTrue(bandejas.getCorreos().contains(correo1));
    }
        
}
