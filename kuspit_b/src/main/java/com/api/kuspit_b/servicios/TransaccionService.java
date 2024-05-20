package com.api.kuspit_b.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import com.api.kuspit_b.repositorios.TransaccionRepository;
import java.util.List;
import com.api.kuspit_b.modelos.Transaccion;

public class TransaccionService {
    @Autowired
    private TransaccionRepository transaccionRepository;

    // Métodos de servicio...
    public List<Transaccion> getTransacciones() {
        return transaccionRepository.findAll();
    }

    public Transaccion getTransaccionById(int id) {
        return transaccionRepository.findById(id);
    }

    public Transaccion saveTransaccion(Transaccion transaccion
    ) {
        return transaccionRepository.save(transaccion);
    }

    public String deleteTransaccion
    (int id) {
        transaccionRepository.deleteById(id);
        return "Transacción eliminada: " + id;
    }

}
