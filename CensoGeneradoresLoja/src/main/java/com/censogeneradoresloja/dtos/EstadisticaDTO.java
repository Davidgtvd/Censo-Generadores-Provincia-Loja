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
public class EstadisticaDTO {
    private int totalFamilias;
    private int familiasConGeneradores;
    private double costoTotalGeneradores;
    private double consumoPromedioPorHora;
    private double generacionPromedioPorHora;

    public EstadisticaDTO(int totalFamilias, int familiasConGeneradores, double costoTotalGeneradores,
                          double consumoPromedioPorHora, double generacionPromedioPorHora) {
        this.totalFamilias = totalFamilias;
        this.familiasConGeneradores = familiasConGeneradores;
        this.costoTotalGeneradores = costoTotalGeneradores;
        this.consumoPromedioPorHora = consumoPromedioPorHora;
        this.generacionPromedioPorHora = generacionPromedioPorHora;
    }
}