/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.controllers;

/**
 *
 * @author david
 */
import com.censogeneradoresloja.dao.TransaccionDAO;
import com.censogeneradoresloja.models.Transaccion;
import com.censogeneradoresloja.models.Generador;
import com.censogeneradoresloja.models.Usuario;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EstadisticasController {
    private final TransaccionDAO transaccionDAO;
    private final GeneradorController generadorController;
    private final UsuarioController usuarioController;

    // Constructor que recibe los controladores
    public EstadisticasController(GeneradorController generadorController, UsuarioController usuarioController) {
        this.transaccionDAO = new TransaccionDAO();
        this.generadorController = generadorController;
        this.usuarioController = usuarioController;
    }

    public Map<String, Long> obtenerEstadisticasCompra() {
        List<Transaccion> transacciones;
        try {
            transacciones = transaccionDAO.obtenerTodas();
        } catch (IOException e) {
            e.printStackTrace();
            return Map.of(); // Devuelve un mapa vacío en caso de error
        }

        return transacciones.stream()
            .filter(t -> "COMPRA".equals(t.getTipoOperacion()))
            .collect(Collectors.groupingBy(
                t -> usuarioController.obtenerUsuarioPorId(t.getUsuarioId())
                                      .map(Usuario::getApellido)
                                      .orElse("Desconocido"),
                Collectors.counting()
            ));
    }

    public double obtenerPromedioConsumo() {
        List<Transaccion> transacciones;
        try {
            transacciones = transaccionDAO.obtenerTodas();
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
        
        return transacciones.stream()
            .filter(t -> "COMPRA".equals(t.getTipoOperacion()))
            .mapToDouble(t -> {
                try {
                    return generadorController.obtenerGeneradorPorId(t.getGeneradorId())
                                                .map(Generador::getConsumoPorHora)
                                                .orElse(0.0); // Retorna 0.0 si el generador no existe
                } catch (IOException e) {
                    e.printStackTrace();
                    return 0.0;
                }
            })
            .average()
            .orElse(0.0); // Retorna 0.0 si no hay promedio disponible
    }

    public double obtenerCostoTotalGeneradores() {
        List<Transaccion> transacciones;
        try {
            transacciones = transaccionDAO.obtenerTodas();
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
        
        return transacciones.stream()
            .filter(t -> "COMPRA".equals(t.getTipoOperacion()))
            .mapToDouble(Transaccion::getMontoTotal)
            .sum();
    }
}