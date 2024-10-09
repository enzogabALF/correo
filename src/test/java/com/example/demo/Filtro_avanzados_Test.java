package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Filtro_avanzados_Test {
    
    @Test
    public void Filtro_por_nombre_y_criterio_email_Test() {
        
       

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

        
        Filtro_por_criterio_y_nombre filtro_por_criterio_y_nombre = new Filtro_por_criterio_y_nombre("Maria", "example.com");

        
        List<Correo> resultado = filtro_por_criterio_y_nombre.aplicarFiltro(destinatario1.getBandejaEntrada().getCorreos());

        
        assertEquals(2, resultado.size());
        assertEquals(correo1, resultado.get(0)); 
        assertEquals(correo2, resultado.get(1)); 
        assertTrue(resultado.contains(correo1));
        assertTrue(resultado.contains(correo2));
        assertFalse(resultado.contains(correo3));
        assertFalse(resultado.contains(correo4));
    }

    @Test
    public void Filtro_por_asunto_y_contenido_Test() {

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

        
        Filtro_por_asunto_y_contenido filtro_por_asunto_y_contenido = new Filtro_por_asunto_y_contenido("Asunto", "contenido");

        
        List<Correo> resultado = filtro_por_asunto_y_contenido.aplicarFiltro(remitente1.getBandejaEnviado().getCorreos());
        
        
        assertEquals(3, resultado.size());
        assertEquals(correo1, resultado.get(0)); 
        assertEquals(correo2, resultado.get(1)); 
        assertTrue(resultado.contains(correo1));
        assertTrue(resultado.contains(correo2));
        assertTrue(resultado.contains(correo3));
        assertFalse(resultado.contains(correo4));
        
    }



}