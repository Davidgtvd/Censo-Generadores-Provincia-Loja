/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.models;

/**
 *
 * @author david
 */
public class Transaccion {
    private Long id;
    private String descripcion;
    private Double costo;
    private Double consumoPorHora;
    private Double generacionPorHora;

    public Transaccion(Long id, String descripcion, Double costo, Double consumoPorHora, Double generacionPorHora) {
        this.id = id;
        this.descripcion = descripcion;
        this.costo = costo;
        this.consumoPorHora = consumoPorHora;
        this.generacionPorHora = generacionPorHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getConsumoPorHora() {
        return consumoPorHora;
    }

    public void setConsumoPorHora(Double consumoPorHora) {
        this.consumoPorHora = consumoPorHora;
    }

    public Double getGeneracionPorHora() {
        return generacionPorHora;
    }

    public void setGeneracionPorHora(Double generacionPorHora) {
        this.generacionPorHora = generacionPorHora;
    }
}