package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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

    @Test
    public void testEnviarCorreo() {
        Contacto remitente = new Contacto("Juan", "juan@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario1 = new Contacto("Ana", "ana@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario2 = new Contacto("Carlos", "carlos@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(destinatario1);
        destinatarios.add(destinatario2);

        Correo correo = new Correo("Asunto Importante", "Contenido del correo", remitente, destinatarios);
        remitente.enviarCorreo(correo);
        destinatario1.recibirCorreo(correo);   
        assertTrue(remitente.getBandejaEnviado().getCorreos().contains(correo));
        assertTrue(destinatario1.getBandejaEntrada().getCorreos().contains(correo));
        assertTrue(destinatario2.getBandejaEntrada().getCorreos().contains(correo));
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

    //Filtro simples

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

    //Filtro avanzados

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

