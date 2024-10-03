package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GestorDeEmailsTest {

    @Test
    public void Enviar_correo_test() {
        Bandeja_de_enviados gestor = new Bandeja_de_enviados();
        Contacto remitente = new Contacto("Juan Perez", "juan.perez@example.com");
        
        Contacto destinatario1 = new Contacto("Maria Lopez", "maria.lopez@example.com");
        List<Contacto> destinatarios = Arrays.asList(destinatario1);
        
        Correo correo = new Correo("Asunto", "Contenido", remitente, destinatarios);
        
        gestor.enviarCorreo(correo);
        
        assertEquals(1, gestor.getBandejaDeEnviados().size());
        assertEquals(correo, gestor.getBandejaDeEnviados().get(0));
    }
}