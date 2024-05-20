package com.api.kuspit_b.repositorios;

import com.api.kuspit_b.modelos.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndContrasena(String email, String contrasena);

    User findByEmail(String email);
    
    User findByNombre(String nombre);
    
    User findUserById(int id);
}
