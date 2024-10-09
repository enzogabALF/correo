package com.example.demo;

import java.util.ArrayList;
import java.util.List;
    
public class Bandejas {
        private List<Correo> correos;
    
        public Bandejas() {
            this.correos = new ArrayList<>();
        }
    
        public List<Correo> getCorreos() {
            return correos;
        }
    
        public void addCorreo(Correo correo) {
            correos.add(correo);
        }
    
        public void removeCorreo(Correo correo) {
            correos.remove(correo);
        }
    
        public void clearCorreos() {
            correos.clear();
        }

        
    }
    


