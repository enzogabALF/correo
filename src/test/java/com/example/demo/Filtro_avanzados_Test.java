package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Filtro_avanzados_Test {
    
    @Test
    public void FiltroPorRemitenteNombreEmailTest() {
        
       

        Contacto remitente1 = new Contacto("Maria Peres ", "Maria@example.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto remitente2 = new Contacto("Maria Garcia", "maria@example.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario1 = new Contacto("Carlos", "carlos@domain.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto remitente3 = new Contacto("Pedro", "pedro@example.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto remitente4 = new Contacto("Maria", "Mari@example.co",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());

       
        Correo correo1 = new Correo("Asunto 1", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));
        Correo correo2 = new Correo("Asunto 2", "Contenido del correo 2", remitente2, Arrays.asList(destinatario1));
        Correo correo3 = new Correo("Asunto 3", "Contenido del correo 3", remitente3, Arrays.asList(destinatario1));
        Correo correo4 = new Correo("Asunto 4", "Contenido del correo 4", remitente4, Arrays.asList(destinatario1));

        destinatario1.recibirCorreo(correo1);
        destinatario1.recibirCorreo(correo2);
        destinatario1.recibirCorreo(correo3);
        destinatario1.recibirCorreo(correo4);

        
        FiltroPorRemitenteNombreEmail FiltroPorRemitenteNE = new FiltroPorRemitenteNombreEmail ("Maria", "example.com");

        
        List<Correo> Resultado = FiltroPorRemitenteNE.aplicarFiltro(destinatario1.getBandejaEntrada().getCorreos());

        
        assertEquals(2, Resultado.size());
        assertEquals(correo1, Resultado.get(0)); 
        assertEquals(correo2, Resultado.get(1)); 
        assertTrue(Resultado.contains(correo1));
        assertTrue(Resultado.contains(correo2));
        assertFalse(Resultado.contains(correo3));
        assertFalse(Resultado.contains(correo4));
    }

    @Test
    public void FiltroporAsuntoYContenidoTest() {

        Contacto remitente1 = new Contacto("Maria Peres", "Maria@example.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario1 = new Contacto("Carlos", "carlos@domain.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
       
        

       
        Correo correo1 = new Correo("Asunto importante", "Este es el contenido de la tarea", remitente1, Arrays.asList(destinatario1));
        Correo correo2 = new Correo("Otro Asunto", "contenido relevante para el filtro", remitente1, Arrays.asList(destinatario1));
        Correo correo3 = new Correo("Asunto irrelevante", "contenido especial que debería pasar el filtro", remitente1, Arrays.asList(destinatario1));
        Correo correo4 = new Correo(" nuevo", "ontenido de prueba", remitente1, Arrays.asList(destinatario1));


        remitente1.enviarCorreo(correo1);
        remitente1.enviarCorreo(correo2);
        remitente1.enviarCorreo(correo3);
        remitente1.enviarCorreo(correo4);

        
        FiltroPorAsuntoYContenido FiltroPorAC = new FiltroPorAsuntoYContenido("Asunto", "contenido");

        
        List<Correo> Resultado = FiltroPorAC.aplicarFiltro(remitente1.getBandejaEnviado().getCorreos());
        
        
        assertEquals(3, Resultado.size());
        assertEquals(correo1, Resultado.get(0)); 
        assertEquals(correo2, Resultado.get(1)); 
        assertTrue(Resultado.contains(correo1));
        assertTrue(Resultado.contains(correo2));
        assertTrue(Resultado.contains(correo3));
        assertFalse(Resultado.contains(correo4));
        
    }



}