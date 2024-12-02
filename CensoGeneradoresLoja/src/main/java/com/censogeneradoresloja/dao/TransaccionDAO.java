/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.dao;

/**
 *
 * @author david
 */
import com.censogeneradoresloja.models.Transaccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransaccionDAO {
    private List<Transaccion> transacciones;

    public TransaccionDAO() {
        this.transacciones = new ArrayList<>();
    }

    public void guardarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    public List<Transaccion> obtenerTodasTransacciones() {
        return new ArrayList<>(transacciones);
    }

    public Transaccion obtenerTransaccionPorId(Long id) {
        return transacciones.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void eliminarTransaccion(Long id) {
        transacciones.removeIf(t -> t.getId().equals(id));
    }

    public void actualizarTransaccion(Transaccion transaccion) {
        int index = transacciones.indexOf(obtenerTransaccionPorId(transaccion.getId()));
        if (index != -1) {
            transacciones.set(index, transaccion);
        }
    }
}