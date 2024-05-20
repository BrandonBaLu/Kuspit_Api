package com.api.kuspit_b.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.kuspit_b.repositorios.CompraRepository;
import com.api.kuspit_b.modelos.Compra;



@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    // Método que obtiene todas las compras
    public Iterable<Compra> getCompras() {
        return compraRepository.findAll();
    }

    // Método que obtiene una compra por su id
    public Compra getCompraById(int id) {
        return compraRepository.findById(id);
    }

    // Método que crea una nueva compra
    public Compra createCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    // Método que trae las compras de un usuario por su id


}
