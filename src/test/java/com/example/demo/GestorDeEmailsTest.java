package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;



@SpringBootTest
public class GestorDeEmailsTest {

 /*   @Test
    public void Enviar_correo_test() {
        Bandejas gestor = new Bandejas();
        Contacto remitente = new Contacto("Juan Perez", "juan.perez@example.com");
        
        Contacto destinatario1 = new Contacto("Maria Lopez", "maria.lopez@example.com");
        List<Contacto> destinatarios = Arrays.asList(destinatario1);
        
        Correo correo = new Correo("Asunto", "Contenido", remitente, destinatarios);
        
        gestor.enviarCorreo(correo);
        
        assertEquals(1, gestor.getBandejaDeEnviados().size());
        assertEquals(correo, gestor.getBandejaDeEnviados().get(0));
    }

    @Test
    public void Bandeja_de_spam_test() {
        Bandejas gestor = new Bandejas();

        Contacto remitente = new Contacto("spam@example.com", "null");  // Simulando correo spam
        Contacto destinatario = new Contacto("usuario@ucp.edu.ar", "usuario@ucp.edu.ar");
        List<Contacto> destinatarios = Arrays.asList(destinatario);

        Correo correoSpam = new Correo("Oferta", "¡Ganaste un premio!", remitente, destinatarios);
        gestor.enviarCorreo(correoSpam);

        gestor.condicionDeSpam(correoSpam);  // Se debería mover a la bandeja de spam

        assertEquals(1, gestor.getBandejaDeSpam().size());  // Verificamos que el correo está en la bandeja de spam
        assertEquals(correoSpam, gestor.getBandejaDeSpam().get(0));  // Verificamos que es el correo correcto
    }



    @Test
    public void Mover_correo_a_papelera_test() {
        Bandejas gestor = new Bandejas();
        List<Correo> papelera = new ArrayList<>();

        Contacto remitente = new Contacto("Juan Perez", "juan.perez@example.com");
        Contacto destinatario = new Contacto("Maria Lopez", "maria.lopez@example.com");
        List<Contacto> destinatarios = Arrays.asList(destinatario);

        Correo correo = new Correo("Asunto", "Contenido", remitente, destinatarios);
        gestor.enviarCorreo(correo);

        gestor.moverACarpetaPapelera(gestor.getBandejaDeEnviados(), papelera, remitente.getEmail(), destinatario.getEmail(), "Asunto");

        assertEquals(0, gestor.getBandejaDeEnviados().size());  // Verificamos que el correo ha sido eliminado de la bandeja de enviados
        assertEquals(1, papelera.size());  // Verificamos que el correo ha sido añadido a la papelera
        assertEquals(correo, papelera.get(0));  // Verificamos que es el correo correcto
    }

    @Test
    public void Enviar_multiples_correos_test() {
        Bandejas gestor = new Bandejas();

        Contacto remitente = new Contacto("Juan Perez", "juan.perez@example.com");
        Contacto destinatario1 = new Contacto("Maria Lopez", "maria.lopez@example.com");
        Contacto destinatario2 = new Contacto("Carlos Ramirez", "carlos.ramirez@example.com");

        List<Contacto> destinatarios1 = Arrays.asList(destinatario1);
        List<Contacto> destinatarios2 = Arrays.asList(destinatario2);

        Correo correo1 = new Correo("Asunto 1", "Contenido 1", remitente, destinatarios1);
        Correo correo2 = new Correo("Asunto 2", "Contenido 2", remitente, destinatarios2);

        gestor.enviarCorreo(correo1);
        gestor.enviarCorreo(correo2);

        assertEquals(2, gestor.getBandejaDeEnviados().size());  // La bandeja de enviados debería tener 2 correos
        assertEquals(correo1, gestor.getBandejaDeEnviados().get(0));
        assertEquals(correo2, gestor.getBandejaDeEnviados().get(1));
    }

    

    @Test
    public void Correo_no_es_spam_test() {
        Bandejas gestor = new Bandejas();
    
        Contacto remitente = new Contacto("usuario@example.com", "usuario@example.com");  // Correo no spam
        Contacto destinatario = new Contacto("usuario@ucp.edu.ar", "usuario@ucp.edu.ar");
        List<Contacto> destinatarios = Arrays.asList(destinatario);
    
        Correo correo = new Correo("Asunto", "Contenido", remitente, destinatarios);
        gestor.enviarCorreo(correo);
    
        gestor.condicionDeSpam(correo);  // Este correo no debería ser considerado como spam
    
        assertEquals(0, gestor.getBandejaDeSpam().size());  // No debería haber correos en la bandeja de spam
    } */


    @Test
    public void testEliminarCorreo() {
        Bandejas bandeja = new Bandejas();
        Contacto contacto = new Contacto("Juan", "juan@example.com");
        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(new Contacto("Ana", "ana@example.com"));
        Correo correo = new Correo("Asunto 1", "Contenido 1", contacto, destinatarios);
        bandeja.addCorreo(correo);

        GestorCorreos gestor = new GestorCorreos();
        gestor.eliminarCorreo(bandeja, correo);

        assertFalse(bandeja.getCorreos().contains(correo));
    }

    @Test
    public void testMoverACarpetaPapelera() {
        Bandejas bandeja = new Bandejas();
        Bandejas papelera = new Bandejas();
        Contacto contacto = new Contacto("Juan", "juan@example.com");
        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(new Contacto("Ana", "ana@example.com"));
        Correo correo = new Correo("Asunto 1", "Contenido 1", contacto, destinatarios);
        bandeja.addCorreo(correo);

        GestorCorreos gestor = new GestorCorreos();
        gestor.moverACarpetaPapelera(bandeja, papelera, correo);

        assertFalse(bandeja.getCorreos().contains(correo));
        assertTrue(papelera.getCorreos().contains(correo));
    }

    @Test
    public void testVaciarPapelera() {
        Bandejas papelera = new Bandejas();
        Contacto contacto = new Contacto("Juan", "juan@example.com");
        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(new Contacto("Ana", "ana@example.com"));
        Correo correo1 = new Correo("Asunto 1", "Contenido 1", contacto, destinatarios);
        Correo correo2 = new Correo("Asunto 2", "Contenido 2", contacto, destinatarios);
        papelera.addCorreo(correo1);
        papelera.addCorreo(correo2);

        GestorCorreos gestor = new GestorCorreos();
        gestor.vaciarPapelera(papelera);

        assertTrue(papelera.getCorreos().isEmpty());
    }

    @Test
    public void testEnviarCorreo() {
        Contacto remitente = new Contacto("Juan", "juan@example.com");
        Contacto destinatario1 = new Contacto("Ana", "ana@example.com");
        Contacto destinatario2 = new Contacto("Carlos", "carlos@example.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(destinatario1);
        destinatarios.add(destinatario2);

        Correo correo = new Correo("Asunto Importante", "Contenido del correo", remitente, destinatarios);

        GestorCorreos gestor = new GestorCorreos();
        gestor.enviarCorreo(correo);

        assertTrue(remitente.getEnviados().getCorreos().contains(correo));
        assertTrue(destinatario1.getBandejaEntrada().getCorreos().contains(correo));
        assertTrue(destinatario2.getBandejaEntrada().getCorreos().contains(correo));
    }

    @Test
    public void testMoverSpamSinRemitente() {
        Bandejas bandeja = new Bandejas();
        Bandejas spam = new Bandejas();
        Contacto contacto = new Contacto("Juan", "juan@example.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(new Contacto("Ana", "ana@example.com"));

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