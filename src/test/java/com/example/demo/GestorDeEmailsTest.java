package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;



@SpringBootTest
public class GestorDeEmailsTest {


    @Test
    public void testEliminarCorreo() {
        Bandejas bandeja = new Bandejas();
        Contacto contacto = new Contacto("Juan", "juan@example.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(new Contacto("Ana", "ana@example.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas()));
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
        Contacto contacto = new Contacto("Juan", "juan@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(new Contacto("Ana", "ana@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas()));
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
        Contacto contacto = new Contacto("Juan", "juan@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(new Contacto("Ana", "ana@example.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas()));
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
        Contacto remitente = new Contacto("Juan", "juan@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario1 = new Contacto("Ana", "ana@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto destinatario2 = new Contacto("Carlos", "carlos@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(destinatario1);
        destinatarios.add(destinatario2);

        Correo correo = new Correo("Asunto Importante", "Contenido del correo", remitente, destinatarios);
        remitente.enviarCorreo(correo);

        assertTrue(remitente.getBandejaEnviado().getCorreos().contains(correo));
        assertEquals(1, destinatario1.getBandejaEntrada().getCorreos().size());
        assertEquals(1, destinatario2.getBandejaEntrada().getCorreos().size());
    }

    @Test
    public void testMoverSpamSinRemitente() {
        Bandejas bandeja = new Bandejas();
        Bandejas spam = new Bandejas();
        Contacto contacto = new Contacto("Juan", "juan@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(new Contacto("Ana", "ana@example.com", new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas()));

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