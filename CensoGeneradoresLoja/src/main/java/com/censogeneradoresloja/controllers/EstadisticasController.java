/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.controllers;

/**
 *
 * @author david
 */
import com.censogeneradoresloja.services.EstadisticasService;

public class EstadisticasController {
    private final GeneradorController generadorController;
    private final UsuarioController usuarioController;
    private final EstadisticasService estadisticasService;

    public EstadisticasController(GeneradorController generadorController, UsuarioController usuarioController, EstadisticasService estadisticasService) {
        this.generadorController = generadorController;
        this.usuarioController = usuarioController;
        this.estadisticasService = estadisticasService;
    }

}