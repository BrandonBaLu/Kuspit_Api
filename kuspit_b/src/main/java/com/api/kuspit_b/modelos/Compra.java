package com.api.kuspit_b.modelos;

import jakarta.persistence.*;


import com.google.protobuf.Timestamp;

@Entity
@Table(name = "Acciones_Compradas")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_compra;
    
    private int id_usuario;
    private int id_accion;
    private double cantidad;
    private Timestamp fecha_compra;

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_accion() {
        return id_accion;
    }

    public void setId_accion(int id_accion) {
        this.id_accion = id_accion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Timestamp getFecha_compra() {
        return fecha_compra;
    }


}
