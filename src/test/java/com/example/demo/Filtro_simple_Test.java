package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Filtro_simple_Test {
    
    @Test
    public void Filtro_por_criterio_email_Test() {

        Contacto destinatario1 = new Contacto("pedro", "profesor@ucp.edu.ar",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto remitente1 = new Contacto("roberto", "estudiante@ar.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto remitente2 = new Contacto("roberto", "estudiante@ucp.edu.ar",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());

        Correo correo1 = new Correo("Tarea", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));
        Correo correo2 = new Correo("Tarea", "Contenido de la tarea", remitente2, Arrays.asList(destinatario1));
        
        destinatario1.recibirCorreo(correo1);
        destinatario1.recibirCorreo(correo2);    

        Filtro_por_criterio_email filtro_por_criterio = new Filtro_por_criterio_email( "@ucp.edu.ar");

        List<Correo> resultado = filtro_por_criterio.aplicarFiltro(destinatario1.getBandejaEntrada().getCorreos());
        
        assertEquals(1, resultado.size());
        assertFalse(resultado.contains(correo1));
        assertTrue(resultado.contains(correo2));

    }

    @Test
    public void Filtro_por_nombre_test() {

        Contacto destinatario1 = new Contacto("pedro", "profesor@ucp.edu.ar",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto remitente1 = new Contacto("roberto", "estudiante@ar.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto remitente2 = new Contacto("JUAN", "estudiante@ar.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        
        Correo correo1 = new Correo("Tarea", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));
        Correo correo2 = new Correo("Tarea1", "Contenido de la tarea2", remitente2, Arrays.asList(destinatario1));

        destinatario1.recibirCorreo(correo1);
        destinatario1.recibirCorreo(correo2);

        Filtro_por_nombre filtro_por_nombre = new Filtro_por_nombre( "roberto");

        List<Correo> resultado = filtro_por_nombre.aplicarFiltro(destinatario1.getBandejaEntrada().getCorreos());
        
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(correo1));
        assertFalse(resultado.contains(correo2));
    }

    @Test
    public void Filtro_por_asunto_test() {

        Contacto destinatario1 = new Contacto("pedro", "profesor@ucp.edu.ar",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto remitente1 = new Contacto("roberto", "estudiante@ar.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto remitente2 = new Contacto("JUAN", "estudiante@ar.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        


        Correo correo1 = new Correo("Tarea", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));
        Correo correo2 = new Correo("papa", "Contenido de la tarea2", remitente2, Arrays.asList(destinatario1));

        remitente1.enviarCorreo(correo1);
        remitente2.enviarCorreo(correo2);

        Filtro_por_asunto filtro_por_asunto = new Filtro_por_asunto( "Tarea");

        List<Correo> resultado = filtro_por_asunto.aplicarFiltro(remitente1.getBandejaEnviado().getCorreos());
        
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(correo1));
        assertFalse(resultado.contains(correo2));
    }


}