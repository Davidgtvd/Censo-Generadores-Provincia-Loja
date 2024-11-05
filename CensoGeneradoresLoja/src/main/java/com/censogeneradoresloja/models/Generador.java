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

public class Generador implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String marca;
    private String modelo; // Propiedad modelo
    private double precio;
    private double consumoPorHora; 
    private double capacidadGeneracion; 
    private String usoDestinado;
    private String propietario;
    private LocalDateTime fechaRegistro;

    // Constructor sin parámetros
    public Generador() {
        this.fechaRegistro = LocalDateTime.now();
    }

    // Constructor con parámetros
    public Generador(Long id, String marca, String modelo, double precio, double consumoPorHora, 
                     double capacidadGeneracion, String usoDestinado, String propietario) {
        this.id = id != null ? id : 0L;  // Valor predeterminado si es null
        this.marca = marca;
        this.modelo = modelo; // Asignación del modelo
        this.precio = precio;
        this.consumoPorHora = consumoPorHora;
        this.capacidadGeneracion = capacidadGeneracion;
        this.usoDestinado = usoDestinado;
        this.propietario = propietario;
        this.fechaRegistro = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; } // Método getter para modelo
    public void setModelo(String modelo) { this.modelo = modelo; } // Método setter para modelo

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public double getConsumoPorHora() { return consumoPorHora; }
    public void setConsumoPorHora(double consumoPorHora) { this.consumoPorHora = consumoPorHora; }

    public double getCapacidadGeneracion() { return capacidadGeneracion; } // Asegúrate de que este método existe
    public void setCapacidadGeneracion(double capacidadGeneracion) { this.capacidadGeneracion = capacidadGeneracion; }

    public String getUsoDestinado() { return usoDestinado; } // Asegúrate de que este método existe
    public void setUsoDestinado(String usoDestinado) { this.usoDestinado = usoDestinado; }

    public String getPropietario() { return propietario; }
    public void setPropietario(String propietario) { this.propietario = propietario; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    @Override
    public String toString() {
        return "Generador{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' + // Mostrar modelo
                ", precio=" + precio +
                ", consumoPorHora=" + consumoPorHora +
                ", capacidadGeneracion=" + capacidadGeneracion +
                ", usoDestinado='" + usoDestinado + '\'' +
                ", propietario='" + propietario + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}