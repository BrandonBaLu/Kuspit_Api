package com.api.kuspit_b.repositorios;

import com.api.kuspit_b.modelos.Accion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccionRepository extends JpaRepository<Accion, Integer> {
    Accion findById(int id);
    
}