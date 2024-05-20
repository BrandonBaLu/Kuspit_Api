package com.api.kuspit_b.servicios;

import com.api.kuspit_b.modelos.User;
import com.api.kuspit_b.repositorios.UserRepository;

import java.util.ArrayList;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String register(User user) {
        // devuelve el  status de la operación
        userRepository.save(user);
        return "Usuario registrado";
    }

    public User getUser(int id) {
        // Lógica para obtener un usuario por su id
        return userRepository.findUserById(id);
    }

    public boolean authenticateUser(String email, String contrasena) {
        if (userRepository.findByEmailAndContrasena(email, contrasena) != null) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<User> getUsers() {
        // Lógica para obtener todos los usuarios
        return (ArrayList<User>) userRepository.findAll();
    }

    public User updateUser(User user) {
        // Lógica para actualizar los datos del usuario
        return userRepository.save(user);
    }

    public String deleteUser(int id) {
        // Lógica para eliminar un usuario
        userRepository.deleteById(id);
        return "Usuario eliminado";
    }


    public boolean userExists(String email) {
        if (userRepository.findByEmail(email) != null) {
            return true;
        } else {
            return false;
        }
    }


    public String getUserId(String email) {
        User user = userRepository.findByEmail(email);
        return user.getId().toString();
    }


}