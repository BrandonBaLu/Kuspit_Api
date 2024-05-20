package com.api.kuspit_b.modelos;


import jakarta.persistence.*;

@Entity
@Table(name = "Acciones_Disponibles")
public class Accion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Accion ;

    private String simbolo;
    private String nombre_empresa;
    private double ultimo_precio;
    private double volumen;

    // Getters y setters


    public int getId_Accion() {
        return id_Accion;
    }

    public void setId_Accion(int id_Accion) {
        this.id_Accion = id_Accion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public double getUltimo_precio() {
        return ultimo_precio;
    }

    public void setUltimo_precio(double ultimo_precio) {
        this.ultimo_precio = ultimo_precio;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }
}