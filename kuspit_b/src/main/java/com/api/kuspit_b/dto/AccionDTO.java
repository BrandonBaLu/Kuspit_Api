package com.api.kuspit_b.dto;

public class AccionDTO {
    private Long id_accion;
    private String simbolo;
    private String nombre_empresa;
    private double ultimo_precio;
    private double volumen;


    //Getters y Setters


    public Long getId_accion() {
        return id_accion;
    }

    public void setId_accion(Long id_accion) {
        this.id_accion = id_accion;
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
