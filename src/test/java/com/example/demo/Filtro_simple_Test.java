package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Filtro_simple_Test {
    
    @Test
    public void FiltroPorRemitenteEmailTest() {

        Contacto destinatario1 = new Contacto("pedro", "profesor@ucp.edu.ar",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto remitente1 = new Contacto("roberto", "estudiante@ar.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto remitente2 = new Contacto("roberto", "estudiante@ucp.edu.ar",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());

        Correo correo1 = new Correo("Tarea", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));
        Correo correo2 = new Correo("Tarea", "Contenido de la tarea", remitente2, Arrays.asList(destinatario1));
        
        destinatario1.recibirCorreo(correo1);
        destinatario1.recibirCorreo(correo2);    

        FiltroPorRemitenteEmail FiltroPorRemitenteE = new FiltroPorRemitenteEmail( "@ucp.edu.ar");

        List<Correo> Resultado = FiltroPorRemitenteE.aplicarFiltro(destinatario1.getBandejaEntrada().getCorreos());
        
        assertEquals(1, Resultado.size());
        assertFalse(Resultado.contains(correo1));
        assertTrue(Resultado.contains(correo2));

    }

    @Test
    public void FiltroPorNombreDelRemitenteTest() {

        Contacto destinatario1 = new Contacto("pedro", "profesor@ucp.edu.ar",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto remitente1 = new Contacto("roberto", "estudiante@ar.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto remitente2 = new Contacto("JUAN", "estudiante@ar.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        
        Correo correo1 = new Correo("Tarea", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));
        Correo correo2 = new Correo("Tarea1", "Contenido de la tarea2", remitente2, Arrays.asList(destinatario1));

        destinatario1.recibirCorreo(correo1);
        destinatario1.recibirCorreo(correo2);

        FiltroPorRemitenteNombre FiltroPorNombreDelRemitente = new FiltroPorRemitenteNombre( "roberto");

        List<Correo> Resultado = FiltroPorNombreDelRemitente.aplicarFiltro(destinatario1.getBandejaEntrada().getCorreos());
        
        assertEquals(1, Resultado.size());
        assertTrue(Resultado.contains(correo1));
        assertFalse(Resultado.contains(correo2));
    }

    @Test
    public void FiltroPorAsuntoTest() {

        Contacto destinatario1 = new Contacto("pedro", "profesor@ucp.edu.ar",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto remitente1 = new Contacto("roberto", "estudiante@ar.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto remitente2 = new Contacto("JUAN", "estudiante@ar.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        


        Correo correo1 = new Correo("Tarea", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));
        Correo correo2 = new Correo("papa", "Contenido de la tarea2", remitente2, Arrays.asList(destinatario1));

        remitente1.enviarCorreo(correo1);
        remitente2.enviarCorreo(correo2);

        FiltroPorAsunto FiltroPorA = new FiltroPorAsunto( "Tarea");

        List<Correo> Resultado = FiltroPorA.aplicarFiltro(remitente1.getBandejaEnviado().getCorreos());
        
        assertEquals(1, Resultado.size());
        assertTrue(Resultado.contains(correo1));
        assertFalse(Resultado.contains(correo2));
    }


}