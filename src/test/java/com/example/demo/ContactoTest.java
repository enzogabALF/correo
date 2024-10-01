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
    @Test
    public void teatVariosContactos(){
        Contacto contacto1= new Contacto("Enzo Alfonso", "Enzo_alfonso@gmail.com");
        Contacto contacto2= new Contacto("jeuel","null");
        Contacto contacto3= new Contacto("null","carla_mart@gmail.com");

        assertEquals("Enzo Alfonso", contacto1.getNombre());
        assertEquals("Enzo_alfonso@gmail.com", contacto1.getEmail());

        assertEquals("jeuel", contacto2.getNombre());
        assertEquals("null", contacto2.getEmail());

        assertEquals("null", contacto3.getNombre());
        assertEquals("carla_mart@gmail.com", contacto3.getEmail());
    }
}
