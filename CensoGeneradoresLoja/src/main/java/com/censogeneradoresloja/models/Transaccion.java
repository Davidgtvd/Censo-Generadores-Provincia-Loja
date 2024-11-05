/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.models;

/**
 *
 * @author david
 */
import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaccion implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String tipoOperacion; 
    private String descripcion;
    private LocalDateTime fecha; // Eliminamos `final` para que pueda modificarse
    private Long generadorId;
    private Long usuarioId;
    private double montoTotal;

    // Constructor sin parámetros
    public Transaccion() {
        this.fecha = LocalDateTime.now();
    }

    // Constructor con parámetros
    public Transaccion(Long id, String tipoOperacion, String descripcion, Long generadorId, Long usuarioId, double montoTotal) {
        this.id = (id != null) ? id : 0L;
        this.tipoOperacion = tipoOperacion;
        this.descripcion = descripcion;
        this.generadorId = (generadorId != null) ? generadorId : 0L;
        this.usuarioId = (usuarioId != null) ? usuarioId : 0L;
        this.fecha = LocalDateTime.now();
        this.montoTotal = montoTotal;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipoOperacion() { return tipoOperacion; }
    public void setTipoOperacion(String tipoOperacion) { this.tipoOperacion = tipoOperacion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; } // Añadimos el setter para `fecha`

    public Long getGeneradorId() { return generadorId; }
    public void setGeneradorId(Long generadorId) { this.generadorId = generadorId; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }

    @Override
    public String toString() {
        return "Transaccion{" +
                "id=" + id +
                ", tipoOperacion='" + tipoOperacion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", generadorId=" + generadorId +
                ", usuarioId=" + usuarioId +
                ", montoTotal=" + montoTotal +
                '}';
    }
}