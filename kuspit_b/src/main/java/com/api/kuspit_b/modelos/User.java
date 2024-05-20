package com.api.kuspit_b.modelos;


import jakarta.persistence.*;
//import java.util.List;

@Entity
@Table(name = "Usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String phone;
    private Integer saldo;

    /*
    @OneToMany(mappedBy = "usuario")
    private List<Compra> accionesCompradas;

    @OneToMany(mappedBy = "usuario")
    private List <Transaccion> transacciones;*/
    // Getters y setters

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String correo) {
        this.email = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public Integer getSaldo() {
        return saldo;
    }
    
    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Object getId() {
        //regresa el id del usuario
        return this.id_usuario;
    }
}