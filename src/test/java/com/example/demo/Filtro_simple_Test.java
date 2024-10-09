package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Filtro_simple_Test {
    
    @Test
    public void Filtro_por_criterio_email_cuando_se_cumple_Test() {
       
        
        
        Contacto remitente1 = new Contacto("pedro", "profesor@ucp.edu.ar");
        Contacto destinatario1 = new Contacto("roberto", "estudiante@ar.com");
    
        
        Correo correo1 = new Correo("Tarea", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));

        remitente1.enviarCorreo(correo1);

       
        Filtro_por_criterio_email filtro_por_criterio = new Filtro_por_criterio_email ("@ucp.edu.ar");

        List<Correo> resultado = filtro_por_criterio.aplicarFiltro(remitente1.getBandejaEnviado());

        
        assertEquals(1, resultado.size());
        assertEquals(correo1, resultado.get(0));
        
    }

    @Test
    public void Filtro_por_criterio_email_cuando_no_se_cumple_Test() {

       GestorCorreos gestor = new GestorCorreos();

        Contacto destinatario1 = new Contacto("pedro", "profesor@ucp.edu.ar");
        Contacto remitente1 = new Contacto("roberto", "estudiante@ar.com");

        Correo correo1 = new Correo("Tarea", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));

        remitente1.enviarCorreo(correo1);

        Filtro_por_criterio_email filtro_por_criterio = new Filtro_por_criterio_email( "@ucp.edu.ar");

        List<Correo> resultado = filtro_por_criterio.aplicarFiltro(remitente1.getBandejaEnviado());

        
        assertEquals(0, resultado.size());
        assertFalse(resultado.contains(correo1));

    }

    @Test
    public void Filtro_por_nombre_test() {

        GestorCorreos gestor = new GestorCorreos();

        Contacto destinatario1 = new Contacto("pedro", "profesor@ucp.edu.ar");
        Contacto remitente1 = new Contacto("roberto", "estudiante@ar.com");

        Correo correo1 = new Correo("Tarea", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));

        remitente1.enviarCorreo(correo1);

        Filtro_por_nombre filtro_por_nombre = new Filtro_por_nombre( "");

        List<Correo> resultado = filtro_por_nombre.aplicarFiltro(remitente1.getBandejaEnviado());

        
        assertEquals(0, resultado.size());
        assertFalse(resultado.contains(correo1));

    }


}