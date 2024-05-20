package com.api.kuspit_b.servicios;

import com.api.kuspit_b.modelos.Accion;
import com.api.kuspit_b.repositorios.AccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccionService {

    @Autowired
    private AccionRepository accionRepository;

    // Método que obtiene todas las acciones disponibles
    public List<Accion> getAccionesDisponibles() {
        return accionRepository.findAll();
    }

    // Método que obtiene una acción por su id
    public Accion getAccionById(int id) {
        return accionRepository.findById(id);
    }

    // Método que crea una nueva acción
    public Accion createAccion(Accion accion) {
        return accionRepository.save(accion);
    }

    // Método que actualiza una acción por su id
    public Accion updateAccion(int id, Accion accion) {
        Accion accionActual = accionRepository.findById(id);
        if (accionActual != null) {
            accionActual.setSimbolo(accion.getSimbolo());
            accionActual.setNombre_empresa(accion.getNombre_empresa());
            accionActual.setUltimo_precio(accion.getUltimo_precio());
            accionActual.setVolumen(accion.getVolumen());
            return accionRepository.save(accionActual);
        }
        return null;
    }
    // Método que elimina una acción por su id
    public void deleteAccion(int id) {
        accionRepository.deleteById(id);
    }

    // Otros métodos de servicio...
}
