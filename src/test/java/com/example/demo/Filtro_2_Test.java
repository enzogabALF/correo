package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Filtro_2_Test {
    
    @Test
    public void Filtro_2_test() {
        Bandejas gestor = new Bandejas();
        Contacto remitente1 = new Contacto("profesor@ucp.edu.ar", "profesor@ucp.edu.ar");
        Contacto destinatario1 = new Contacto("estudiante@ucp.edu.ar", "estudiante@ucp.edu.ar");
    
        Correo correo1 = new Correo("Tarea", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));
        gestor.enviarCorreo(correo1);

        
        Filtro_2 filtro = new Filtro_2("Correos de la UCP", Arrays.asList("Tarea", "@ucp.edu.ar"), true);
        List<Correo> resultado = filtro.aplicarFiltro(gestor.getBandejaDeEnviados());

        assertEquals(1, resultado.size());
        assertEquals(correo1, resultado.get(0));
    }

    @Test
    public void Filtro_2_con_criterios_de_asunto_contenido_y_remitente_test() {
        Bandejas gestor = new Bandejas();

        Contacto remitente1 = new Contacto("profesor@ucp.edu.ar", "profesor@ucp.edu.ar");
        Contacto destinatario1 = new Contacto("estudiante@ucp.edu.ar", "estudiante@ucp.edu.ar");
        Contacto remitente2 = new Contacto("admin@gmail.com", "admin@gmail.com");

        Correo correo1 = new Correo("Tarea", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));
        Correo correo2 = new Correo("Aviso", "Contenido importante", remitente2, Arrays.asList(destinatario1));
        Correo correo3 = new Correo("Reunion", "Reunión el lunes", remitente1, Arrays.asList(destinatario1));

        gestor.enviarCorreo(correo1);
        gestor.enviarCorreo(correo2);
        gestor.enviarCorreo(correo3);
   
        
        Filtro_2 filtroAvanzado = new Filtro_2("Filtro avanzado", Arrays.asList("admin", "tarea"), false);
        List<Correo> resultado = filtroAvanzado.aplicarFiltro(gestor.getBandejaDeEnviados());
    
        assertEquals(1, resultado.size());  
        assertEquals(correo3, resultado.get(0));  
    }
}
