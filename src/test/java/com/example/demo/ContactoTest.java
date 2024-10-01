package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ContactoTest {

    @Test
    public void testCrearContacto() {
        Contacto contacto = new Contacto("Juan Perez", "juan.perez@example.com");
        assertEquals("Juan Perez", contacto.getNombre());
        assertEquals("juan.perez@example.com", contacto.getEmail());
    }
    @Test
    public void testNombreVacio() {
        Contacto contacto = new Contacto("", "juan.perez@example.com");
        assertEquals("", contacto.getNombre());
        assertEquals("juan.perez@example.com", contacto.getEmail());
    }
    
}