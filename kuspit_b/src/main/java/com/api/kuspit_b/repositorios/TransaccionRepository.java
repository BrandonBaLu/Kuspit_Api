package com.api.kuspit_b.repositorios;

import com.api.kuspit_b.modelos.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {
    Transaccion findById(int id); // Método
    void deleteById(int id); // Método
}
