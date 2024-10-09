package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class Unificacion_Test {

    
    @Test
    public void Crear_contacto_test() {
        Contacto contacto = new Contacto("Juan Perez", "juan.perez@example.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        assertEquals("Juan Perez", contacto.getNombre());
        assertEquals("juan.perez@example.com", contacto.getEmail());
    }

    @Test
    public void Nombre_vacio_test() {
        Contacto contacto = new Contacto("", "juan.perez@example.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        assertEquals("", contacto.getNombre());
        assertEquals("juan.perez@example.com", contacto.getEmail());
    }

    @Test
    public void Varios_contactos_test() {
        Contacto contacto1 = new Contacto("Enzo Alfonso", "Enzo_alfonso@gmail.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto contacto2 = new Contacto("jeuel", "null",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto contacto3 = new Contacto("null", "carla_mart@gmail.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());

        assertEquals("Enzo Alfonso", contacto1.getNombre());
        assertEquals("Enzo_alfonso@gmail.com", contacto1.getEmail());
        assertEquals("jeuel", contacto2.getNombre());
        assertEquals("null", contacto2.getEmail());
        assertEquals("null", contacto3.getNombre());
        assertEquals("carla_mart@gmail.com", contacto3.getEmail());
    }

    // Tests de Correo
    @Test
    public void Creacion_de_un_correo_test() {
        Contacto remitente = new Contacto("Enzo Alfonso", "Enzo_alfonso@gmail.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario1 = new Contacto("Carla Martinez", "carla_mart@gmail.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        List<Contacto> destinatarios = Arrays.asList(destinatario1);

        Correo correo = new Correo("asunto", "contenido", remitente, destinatarios);

        assertEquals("asunto", correo.getAsunto());
        assertEquals("contenido", correo.getContenido());
        assertEquals(remitente, correo.getRemitente());
        assertEquals(1, correo.getDestinatarios().size());
        assertEquals(destinatario1, correo.getDestinatarios().get(0));
    }

    @Test
    public void Creacion_de_correo_sin_asunto_test() {
        Contacto remitente = new Contacto("Enzo Alfonso", "Enzo_alfonso@gmail.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
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
    public void Crear_correo_con_multiples_destinatarios_test() {
        Contacto remitente = new Contacto("Juan Perez", "juan.perez@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario1 = new Contacto("Maria Lopez", "maria.lopez@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario2 = new Contacto("Carlos Gomez", "carlos.gomez@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
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
    public void Enviar_correo_con_multiples_destinatarios_test() {
        
        Contacto remitente = new Contacto("Juan Perez", "juan.perez@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario1 = new Contacto("Maria Lopez", "maria.lopez@example.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario2 = new Contacto("Carlos Gomez", "carlos.gomez@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        List<Contacto> destinatarios = Arrays.asList(destinatario1, destinatario2);

        Correo correo = new Correo("Asunto", "Contenido", remitente, destinatarios);
  
        remitente.getBandejaEntrada().addCorreo(correo);

        assertNotNull(remitente.getBandejaEnviado());
        
    }


    // Tests de Filtro 1
    @Test
    public void Filtro_1_por_remitente_test() {
        GestorCorreos gestor = new GestorCorreos();
        Contacto remitente1 = new Contacto("profesor@ucp.edu.ar", "profesor@ucp.edu.ar");
        Contacto destinatario1 = new Contacto("estudiante@ucp.edu.ar", "estudiante@ucp.edu.ar");
        Correo correo1 = new Correo("Tarea", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));
        remitente1.getBandejaEnviado().addCorreo(correo1);
        

        Filtro_por_criterio_email filtro = new Filtro_por_criterio_email("Correos de la UCP", "@ucp.edu.ar");
        List<Correo> resultado = filtro.aplicarFiltro(remitente1.getBandejaEnviado());

        assertEquals(1, resultado.size());
        assertEquals(correo1, resultado.get(0));
    }

    // Tests de Filtro 2
    @Test
    public void Filtro_2_test() {
        GestorCorreos gestor = new GestorCorreos();
        Contacto remitente1 = new Contacto("profesor@ucp.edu.ar", "profesor@ucp.edu.ar");
        Contacto destinatario1 = new Contacto("estudiante@ucp.edu.ar", "estudiante@ucp.edu.ar");
        Correo correo1 = new Correo("Tarea", "Contenido de la tarea", remitente1, Arrays.asList(destinatario1));
        remitente1.enviarCorreo(correo1);

        Filtro_por_criterio_y_nombre filtro = new Filtro_por_criterio_y_nombre("Correos de la UCP", Arrays.asList("Tarea", "@ucp.edu.ar"), true);
        List<Correo> resultado = filtro.aplicarFiltro(remitente1.getBandejaEnviado());

        assertEquals(1, resultado.size());
        assertEquals(correo1, resultado.get(0));
    }

    // Tests de GestorDeEmails
    @SuppressWarnings("unchecked")
    @Test
    public void Enviar_correo_test() {
        
        Contacto remitente = new Contacto("Juan Perez", "juan.perez@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario1 = new Contacto("Maria Lopez", "maria.lopez@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        
        List<Contacto> destinatarios = Arrays.asList(destinatario1);
        Correo correo = new Correo("Asunto", "Contenido", remitente, destinatarios);
        remitente.enviarCorreo(correo);

        assertEquals(1, ((List<Contacto>) remitente.getBandejaEnviado()).size());
        assertEquals(correo,remitente.getBandejaEnviado());
    }

   
    @Test
    public void testMoverSpamSinRemitente() {
        Bandejas bandeja = new Bandejas();
        Bandejas spam = new Bandejas();
        Contacto contacto = new Contacto("Juan", "juan@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(new Contacto("Ana", "ana@example.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas()));

        Correo correo1 = new Correo("Asunto 1", "Contenido 1", null, destinatarios); // Sin remitente
        Correo correo2 = new Correo("Asunto 2", "Contenido 2", contacto, destinatarios);

        bandeja.addCorreo(correo1);
        bandeja.addCorreo(correo2);

        GestorCorreos gestor = new GestorCorreos();
        gestor.moverSpamSinRemitente(bandeja, spam);

        assertFalse(bandeja.getCorreos().contains(correo1));
        assertTrue(spam.getCorreos().contains(correo1));
        assertTrue(bandeja.getCorreos().contains(correo2));
    }
}
