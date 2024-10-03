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
        Bandeja_de_enviados gestor = new Bandeja_de_enviados();
        Contacto remitente1 = new Contacto("profesor@ucp.edu.ar", "profesor@ucp.edu.ar");
        Contacto destinatario1 = new Contacto("estudiante@ucp.edu.ar", "estudiante@ucp.edu.ar");
    
        Correo correo1 = new Correo("Tarea", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));
        gestor.enviarCorreo(correo1);

        Filtro_2 filtro = new Filtro_2("Correos de la UCP", Arrays.asList("Tarea", "@ucp.edu.ar"));
        List<Correo> resultado = filtro.aplicarFiltro(gestor.getBandejaDeEnviados());

        assertEquals(1, resultado.size());
        assertEquals(correo1, resultado.get(0));
    }

}
