/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.dtos;

/**
 *
 * @author david
 */

import lombok.Data;

@Data
public class GeneradorDTO {
    private Long id; 
    private String modelo;
    private String marca;
    private double costo;
    private double consumoPorHora;
    private double potenciaGenerada;
    private String uso;

    public GeneradorDTO(Long id, String modelo, String marca, double costo, double consumoPorHora,
                        double potenciaGenerada, String uso) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
        this.consumoPorHora = consumoPorHora;
        this.potenciaGenerada = potenciaGenerada;
        this.uso = uso;
    }
}