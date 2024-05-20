package com.api.kuspit_b.controladores;


import com.api.kuspit_b.dto.AccionDTO;

import com.api.kuspit_b.modelos.Accion;

import com.api.kuspit_b.servicios.AccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://kuspit_bolsa_f.test")
@RequestMapping("/acciones")
public class AccionController {

    @Autowired
    private AccionService accionService;

    @GetMapping("/disponibles")
    // Método que obtiene todas las acciones disponibles
    public List<Accion> getAccionesDisponibles() {
        return accionService.getAccionesDisponibles();
    }

    @GetMapping("/disponibles/{id}")
    // Método que obtiene una acción por su id
    public Accion getAccionById(@PathVariable int id) {
        return accionService.getAccionById(id);
    }

    @PostMapping("/disponibles")
    // Método que crea una nueva acción
    public Accion createAccion(@RequestBody Accion accion) {
        return accionService.createAccion(accion);
    }

   @PutMapping("disponibles/{id}")
    public Accion updateUser(@PathVariable int id, @RequestBody AccionDTO accionDTO) {
        try {
            Accion accion = new Accion();
            //consultar el usuario por id
            accion = accionService.getAccionById(id);
            System.out.println("id Accion: " + accion.getId_Accion());
            //actualizar los datos del usuario
            accion.setVolumen(accionDTO.getVolumen());
            //guardar los cambios
            return accionService.updateAccion(id, accion);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/disponibles/{id}")
    // Método que elimina una acción por su id
    public void deleteAccion(@PathVariable int id) {
        accionService.deleteAccion(id);
    }
}
