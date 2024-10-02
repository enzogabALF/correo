package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GestorDeEmailsTest {

    @Test
    public void testEnviarCorreo() {
        Bandeja_de_enviados gestor = new Bandeja_de_enviados();
        Contacto remitente = new Contacto("Juan Perez", "juan.perez@example.com");
        Contacto destinatario = new Contacto("Maria Lopez", "maria.lopez@example.com");
        Correo correo = new Correo("Asunto", "Contenido", remitente, destinatario);
        gestor.enviarCorreo(correo);
        assertEquals(1, gestor.getBandejaDeEnviados().size());
        assertEquals(correo, gestor.getBandejaDeEnviados().get(0));
    }
}
