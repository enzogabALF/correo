package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ContactoTest {

    @Test
    public void Crear_contacto_test() {
    
        Contacto contacto = new Contacto("Juan Perez", "juan.perez@example.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        assertEquals("Juan Perez", contacto.getNombre());
        assertEquals("juan.perez@example.com", contacto.getEmail());
        assertEquals(1, contacto.getBandejaEntrada().size());    }
    @Test
    public void Nombre_vacio_test() {
        Contacto contacto = new Contacto("", "juan.perez@example.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        assertEquals("", contacto.getNombre());
        assertEquals("juan.perez@example.com", contacto.getEmail());
    }
    @Test
    public void Varios_contactos_test(){

        Contacto contacto1= new Contacto("Enzo Alfonso", "Enzo_alfonso@gmail.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto contacto2= new Contacto("jeuel","null",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());
        Contacto contacto3= new Contacto("null","carla_mart@gmail.com",new Bandejas(), new Bandejas(), new Bandejas(), new Bandejas());

        assertEquals("Enzo Alfonso", contacto1.getNombre());
        assertEquals("Enzo_alfonso@gmail.com", contacto1.getEmail());

        assertEquals("jeuel", contacto2.getNombre());
        assertEquals("null", contacto2.getEmail());

        assertEquals("null", contacto3.getNombre());
        assertEquals("carla_mart@gmail.com", contacto3.getEmail());
    }
}
