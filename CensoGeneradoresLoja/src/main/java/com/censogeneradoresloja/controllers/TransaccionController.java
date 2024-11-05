/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.controllers;

/**
 *
 * @author david
 */
import com.censogeneradoresloja.models.Transaccion;
import com.censogeneradoresloja.services.TransaccionService;

import java.util.List;

public class TransaccionController {
    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    public void crearTransaccion(Transaccion transaccion) {
        transaccionService.guardarTransaccion(transaccion);
    }

    public List<Transaccion> obtenerTodasTransacciones() {
        return transaccionService.obtenerTodasTransacciones();
    }

    public Transaccion obtenerTransaccionPorId(Long id) {
        return transaccionService.obtenerTransaccionPorId(id);
    }

    public void actualizarTransaccion(Transaccion transaccion) {
        transaccionService.actualizarTransaccion(transaccion);
    }

    public void eliminarTransaccion(Long id) {
        transaccionService.eliminarTransaccion(id);
    }

    }