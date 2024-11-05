/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.models;

/**
 *
 * @author david
 */
public class Generador {
    private Long id;
    private String marca;
    private String modelo;
    private Double costo;
    private Double consumoPorHora;
    private Double potenciaGenerada;
    private String uso;
    private String familia;

    public Generador(Long id, String marca, String modelo, Double costo, Double consumoPorHora, Double potenciaGenerada, String uso, String familia) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costo;
        this.consumoPorHora = consumoPorHora;
        this.potenciaGenerada = potenciaGenerada;
        this.uso = uso;
        this.familia = familia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    public Double getPotenciaGenerada() {
        return potenciaGenerada;
    }

    public void setPotenciaGenerada(Double potenciaGenerada) {
        this.potenciaGenerada = potenciaGenerada;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

}