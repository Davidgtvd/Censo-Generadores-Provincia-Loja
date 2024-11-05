/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.services;

/**
 *
 * @author david
 */
import com.censogeneradoresloja.models.Transaccion;
import com.censogeneradoresloja.dao.TransaccionDAO; 

import java.util.List;

public class TransaccionService {
    private final TransaccionDAO transaccionDAO; 

    public TransaccionService(TransaccionDAO transaccionDAO) {
        this.transaccionDAO = transaccionDAO; 
    }

    public void guardarTransaccion(Transaccion transaccion) {
        transaccionDAO.guardarTransaccion(transaccion);
    }

    public List<Transaccion> obtenerTodasTransacciones() {
        return transaccionDAO.obtenerTodasTransacciones();
    }

    public Transaccion obtenerTransaccionPorId(Long id) {
        return transaccionDAO.obtenerTransaccionPorId(id);
    }

    public void eliminarTransaccion(Long id) {
        transaccionDAO.eliminarTransaccion(id);
    }

    public void actualizarTransaccion(Transaccion transaccion) {
        transaccionDAO.actualizarTransaccion(transaccion);
    }
}