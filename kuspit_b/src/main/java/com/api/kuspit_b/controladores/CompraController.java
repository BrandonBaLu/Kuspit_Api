package com.api.kuspit_b.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.api.kuspit_b.modelos.Compra;

import com.api.kuspit_b.servicios.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    // Método que obtiene todas las compras
    @GetMapping("/compra")
    public Iterable<Compra> getAllCompras() {
        return compraService.getCompras();
    }

    // Método que obtiene una compra por su id
    @GetMapping("compra/{id}")
    public Compra getCompraById(@PathVariable int id) {
        return compraService.getCompraById(id);
    }

    // Método que crea una nueva compra
    @PostMapping("/compra")
    public Compra createCompra(@RequestBody Compra compra) {
        return compraService.createCompra(compra);
    }

   



}

