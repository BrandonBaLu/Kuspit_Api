package com.api.kuspit_b.repositorios;

import com.api.kuspit_b.modelos.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
    Compra findById(int id);
    void deleteById(int id);
}
    