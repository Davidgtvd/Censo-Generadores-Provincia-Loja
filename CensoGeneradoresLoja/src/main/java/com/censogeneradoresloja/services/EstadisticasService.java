/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.services;

/**
 *
 * @author david
 */
import com.censogeneradoresloja.dao.GeneradorDAO;
import com.censogeneradoresloja.dao.TransaccionDAO;
import com.censogeneradoresloja.dtos.EstadisticaDTO;
import com.censogeneradoresloja.models.Generador;
import com.censogeneradoresloja.models.Transaccion;

import java.util.List;
import java.util.Map;

public class EstadisticasService {

    private final GeneradorDAO generadorDAO;
    private final TransaccionDAO transaccionDAO;

    public EstadisticasService(GeneradorDAO generadorDAO, TransaccionDAO transaccionDAO) {
        this.generadorDAO = generadorDAO;
        this.transaccionDAO = transaccionDAO;
    }

    public EstadisticaDTO obtenerEstadisticas() {
        List<Transaccion> transacciones = transaccionDAO.obtenerTodasTransacciones();
        Map<String, Integer> comprasPorFamilia = generadorDAO.obtenerComprasPorFamilia();

        int totalFamilias = comprasPorFamilia.size();
        int familiasConGeneradores = (int) comprasPorFamilia.values().stream().filter(cantidad -> cantidad > 0).count();
        double costoTotal = calcularCostoTotal(transacciones);
        double promedioConsumo = calcularPromedioConsumo(transacciones);
        double promedioGeneracion = calcularPromedioGeneracion(transacciones);

        return new EstadisticaDTO(totalFamilias, familiasConGeneradores, costoTotal, promedioConsumo, promedioGeneracion);
    }

    private double calcularPromedioConsumo(List<Transaccion> transacciones) {
        double totalConsumo = transacciones.stream()
                .mapToDouble(Transaccion::getConsumoPorHora)
                .sum();
        return transacciones.size() > 0 ? totalConsumo / transacciones.size() : 0;
    }

    private double calcularPromedioGeneracion(List<Transaccion> transacciones) {
        double totalGeneracion = transacciones.stream()
                .mapToDouble(Transaccion::getGeneracionPorHora)
                .sum();
        return transacciones.size() > 0 ? totalGeneracion / transacciones.size() : 0;
    }

    private double calcularCostoTotal(List<Transaccion> transacciones) {
        return transacciones.stream()
                .mapToDouble(Transaccion::getCosto)
                .sum();
    }

    public int getTotalGeneradores() {
        return generadorDAO.contarGeneradores();
    }

   public double getCapacidadTotal() {
        return generadorDAO.obtenerTodosGeneradores()
                           .stream()
                           .mapToDouble(Generador::getPotenciaGenerada)
                           .sum();
    }

    public Generador getMayorGenerador() {
        return generadorDAO.obtenerTodosGeneradores()
                           .stream()
                           .max((g1, g2) -> Double.compare(g1.getPotenciaGenerada(), g2.getPotenciaGenerada()))
                           .orElse(null);
    }
}