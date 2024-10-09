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
        
        Contacto remitente1 = new Contacto("Maria Peres ", "Maria@example.com");
        Contacto remitente2 = new Contacto("Maria Garcia", "maria@example.com");
        Contacto destinatario1 = new Contacto("Carlos", "carlos@domain.com");
        Contacto remitente3 = new Contacto("Pedro", "pedro@example.com");
        Contacto remitente4 = new Contacto("Maria", "Mari@example.co");

       
        Correo correo1 = new Correo("Asunto 1", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));
        Correo correo2 = new Correo("Asunto 2", "Contenido del correo 2", remitente2, Arrays.asList(destinatario1));
        Correo correo3 = new Correo("Asunto 3", "Contenido del correo 3", remitente3, Arrays.asList(destinatario1));
        Correo correo4 = new Correo("Asunto 4", "Contenido del correo 4", remitente4, Arrays.asList(destinatario1));

        

        List<Correo> correos = Arrays.asList(correo1, correo2,correo3);

        
        Filtro_por_criterio_y_nombre filtro_criterio_y_nombre = new Filtro_por_criterio_y_nombre("Maria", "example.com");

        
        List<Correo> correosFiltrados = filtro_criterio_y_nombre.aplicarFiltro(correos);

        
        assertEquals(2, correosFiltrados.size());
        assertEquals(correo1, correosFiltrados.get(0)); 
        assertEquals(correo2, correosFiltrados.get(1)); 
        assertTrue(correosFiltrados.contains(correo1));
        assertTrue(correosFiltrados.contains(correo2));
        assertFalse(correosFiltrados.contains(correo3));
        assertFalse(correosFiltrados.contains(correo4));
    }

    @Test
    public void Filtro_por_asunto_y_contenido_Test() {

        Contacto remitente1 = new Contacto("Maria Peres", "Maria@example.com");
        Contacto remitente2 = new Contacto("Maria Garcia", "maria@example.com");
        Contacto destinatario1 = new Contacto("Carlos", "carlos@domain.com");
        Contacto remitente3 = new Contacto("Pedro", "pedro@argentina.com");
        Contacto remitente4 = new Contacto("Mari", "Mari@example.com");

       
        Correo correo1 = new Correo("Asunto importante", "Este es el contenido de la tarea", remitente1, Arrays.asList(destinatario1));
        Correo correo2 = new Correo("Otro Asunto", "contenido relevante para el filtro", remitente2, Arrays.asList(destinatario1));
        Correo correo3 = new Correo("Asunto irrelevante", "contenido especial que debería pasar el filtro", remitente3, Arrays.asList(destinatario1));
        Correo correo4 = new Correo(" nuevo", "ontenido de prueba", remitente4, Arrays.asList(destinatario1));


        List<Correo> correos = Arrays.asList(correo1, correo2, correo3, correo4);

        
        Filtro_por_asunto_y_contenido filtro_por_asunto_y_contenido = new Filtro_por_asunto_y_contenido("Asunto", "contenido");

        
        List<Correo> correosFiltrados = filtro_por_asunto_y_contenido.aplicarFiltro(correos);

        
        assertEquals(3, correosFiltrados.size());
        assertEquals(correo1, correosFiltrados.get(0)); 
        assertEquals(correo2, correosFiltrados.get(1)); 
        assertTrue(correosFiltrados.contains(correo1));
        assertTrue(correosFiltrados.contains(correo2));
        assertTrue(correosFiltrados.contains(correo3));
        assertFalse(correosFiltrados.contains(correo4));
        
    }



}