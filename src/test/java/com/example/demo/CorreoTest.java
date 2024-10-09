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
        Contacto remitente = new Contacto("Enzo Alfonso", "Enzo_alfonso@gmail.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario1 = new Contacto("Carla Martinez", "carla_mart@gmail.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
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
        Contacto remitente = new Contacto("Enzo Alfonso", "Enzo_alfonso@gmail.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario1 = new Contacto("Carla Martinez", "carla_mart@gmail.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());

        
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
        Contacto remitente = new Contacto("Enzo Alfonso", "Enzo_alfonso@gmail.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario1 = new Contacto("", "",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());   //datos vacio para este caso :v

        
        List<Contacto> destinatarios = Arrays.asList(destinatario1);
        
        Correo correo = new Correo("asunto", "contenido", remitente, destinatarios);
        remitente.getBandejaEnviado();
        destinatario1.setBandejaEntrada(destinatario1.getBandejaEntrada());
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
        Contacto remitente = new Contacto("Juan Perez", "juan.perez@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario1 = new Contacto("Maria Lopez", "maria.lopez@example.com",  new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario2 = new Contacto("Carlos Gomez", "carlos.gomez@example.com",  new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());

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
    public void testEnviarYRecibirCorreo() {
        // Configuración inicial
        Contacto remitente = new Contacto("Remitente", "remitente@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario = new Contacto("Destinatario1", "destinatario1@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());

        // Lista de destinatarios
        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(destinatario);

        // Crear el correo
        Correo nuevoCorreo = new Correo("Asunto", "Contenido", remitente, destinatarios);
        
        // Enviar el correo
        remitente.getBandejaEnviado().addCorreo(nuevoCorreo);
        destinatario.getBandejaEntrada().addCorreo(nuevoCorreo);
        // Verificar que el correo está en la bandeja de enviados del remitente
        assertTrue(remitente.getBandejaEnviado().getCorreos().contains(nuevoCorreo));

        // Verificar que el correo está en la bandeja de entrada del destinatario
        assertEquals(1, destinatario.getBandejaEntrada().getCorreos().size());
        Correo correoRecibido = destinatario.getBandejaEntrada().getCorreos().get(0);
        assertEquals("Asunto", correoRecibido.getAsunto());
        assertEquals("Contenido", correoRecibido.getContenido());
        assertEquals(remitente, correoRecibido.getRemitente());
        assertEquals(1, correoRecibido.getDestinatarios().size());
        assertEquals(destinatario, correoRecibido.getDestinatarios().get(0));
    }
        



    @Test
    public void testAddCorreo() {
        Bandejas bandejas = new Bandejas();
        Contacto contacto = new Contacto("Juan", "juan@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        
        Contacto destinatario1= new Contacto("Ana", "ana@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        List<Contacto> destinatarios =  Arrays.asList(destinatario1);
        Correo correo1 = new Correo("Asunto 1", "Contenido 1", contacto, destinatarios);
        bandejas.addCorreo(correo1);
        assertEquals(1, bandejas.getCorreos().size());
        assertTrue(bandejas.getCorreos().contains(correo1));
    }

    @Test
    public void testRemoveCorreo() {
        Bandejas bandejas = new Bandejas();
        Contacto contacto = new Contacto("Juan", "juan@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        
        Contacto destinatario1= new Contacto("Ana", "ana@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        List<Contacto> destinatarios = Arrays.asList(destinatario1);
        Correo correo1 = new Correo("Asunto 1", "Contenido 1", contacto, destinatarios);
        bandejas.addCorreo(correo1);
        bandejas.removeCorreo(correo1);
        assertFalse(bandejas.getCorreos().contains(correo1));
    }

    @Test
    public void testClearCorreos() {
        Bandejas bandejas = new Bandejas();
        Contacto contacto = new Contacto("Juan", "juan@example.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        
        Contacto destinatario= new Contacto("Ana", "ana@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
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
        Contacto contacto = new Contacto("Juan", "juan@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        
        Contacto destinatario= new Contacto("Ana", "ana@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
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
