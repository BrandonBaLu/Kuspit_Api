package com.api.kuspit_b.controladores;

import com.api.kuspit_b.dto.UserDTO;
import com.api.kuspit_b.modelos.User;
import com.api.kuspit_b.servicios.UserService;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://kuspit_bolsa_f.test")

@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    //si existe el nombre y apellido,si el correo ya existe,si se ingresa una conttraseña menor a 8 caracteres se regresa un mensaje de error,
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
        // Verifica si se recibieron datos
        if (user.getNombre().isEmpty() || user.getApellido().isEmpty() || user.getEmail().isEmpty() || user.getContrasena().isEmpty()) {
            return ResponseEntity.badRequest().body("{\"message\": \"Datos incompletos\"}");
        }

        // Verifica si el correo electrónico es válido
        if (!isValidEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("{\"message\": \"Correo electrónico inválido\"}");
        }

        // Verifica si la contraseña tiene al menos 8 caracteres
        if (user.getContrasena().length() < 8) {
            return ResponseEntity.badRequest().body("{\"message\": \"La contraseña debe tener al menos 8 caracteres\"}");
        }

        // Verifica si el usuario ya existe en la base de datos
        boolean userExists = userService.userExists(user.getEmail());

        if (userExists) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\": \"Usuario ya registrado\"}");
        } else {
            userService.register(user);
            return ResponseEntity.ok("{\"message\": \"Usuario registrado\"}");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody User user) {
        // Verifica si se recibieron datos
        if (user.getEmail().isEmpty() || user.getContrasena().isEmpty()) {
            return ResponseEntity.badRequest().body("{\"message\": \"Datos incompletos\"}");
        }

        // Verifica si el correo electrónico es válido
        if (!isValidEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("{\"message\": \"Correo electrónico inválido\"}");
        }

        // Verifica si el usuario existe en la base de datos
        boolean userExists = userService.userExists(user.getEmail());

        if (userExists) {
            // Verifica si la contraseña es correcta
            boolean authenticated = userService.authenticateUser(user.getEmail(), user.getContrasena());
            if (authenticated) {
                //envia el id del usuario y el correo con el mensaje de usuario autenticado
                return ResponseEntity.ok("{\"id_usuario\": " + userService.getUserId(user.getEmail()) + ", \"email\": \"" + user.getEmail() + "\", \"message\": \"Usuario autenticado\"}");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Contraseña incorrecta\"}");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Usuario no encontrado\"}");
        }
    }


    // Método para verificar si el correo electrónico es válido
    private boolean isValidEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    /*@GetMapping(path = "/get_user/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }*/

    //obtener todos los usuarios sin optional
    @GetMapping("/get_user/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    
    @GetMapping("/get_usuarios")
    public Iterable<User> getAllUsers() {
        return userService.getUsers();
    }

    @PutMapping("update/{id}")
    public User updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        try {
            User user = new User();
            //consultar el usuario por id
            user= userService.getUser(id);
            System.out.println("Nombre: "+ user.getNombre());
            user.setSaldo(userDTO.getSaldo());
            return userService.updateUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

        }
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable int id) {
        try {
            return userService.deleteUser(id);
        } catch (Exception e) {
            return "Error al eliminar al usuario";
        }
    }

}