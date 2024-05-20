package com.api.kuspit_b.dto;

public class TransaccionDTO {
    private int id_transaccion;

    private int id_usuario;
    private int id_accion;

    private double cantidad;

    private String fecha_transaccion;   


    public TransaccionDTO() {
    }

    public TransaccionDTO(int id_usuario, int id_accion) {
        this.id_usuario = id_usuario;
        this.id_accion = id_accion;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
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

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha_transaccion() {
        return fecha_transaccion;
    }

    public void setFecha_transaccion(String fecha_transaccion) {
        this.fecha_transaccion = fecha_transaccion;
    }

      
}
