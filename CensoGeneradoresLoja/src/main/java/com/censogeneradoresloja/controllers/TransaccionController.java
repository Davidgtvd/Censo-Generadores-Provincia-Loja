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
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TransaccionController {
    private final TransaccionDAO transaccionDAO;

    public TransaccionController() {
        this.transaccionDAO = new TransaccionDAO();
    }

    /**
     * Registra una nueva transacción.
     * Si la transacción es nula, se crea una nueva con la fecha actual.
     * @param transaccion la transacción a registrar
     */
    public void registrarTransaccion(Transaccion transaccion) {
        // Asigna la fecha en el momento de crear la transacción, si no se hizo antes
        Transaccion nuevaTransaccion = (transaccion != null) ? transaccion : new Transaccion();
        nuevaTransaccion.setFecha(LocalDateTime.now()); // Establecer la fecha actual
        try {
            transaccionDAO.guardar(nuevaTransaccion);
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores, puedes mejorar esto
        }
    }

    /**
     * Obtiene todo el historial de transacciones.
     * @return una lista de transacciones
     */
    public List<Transaccion> obtenerHistorial() {
        try {
            return transaccionDAO.obtenerTodas();
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores, puedes mejorar esto
            return List.of(); // Devuelve una lista vacía en caso de error
        }
    }

    /**
     * Obtiene una transacción por su ID.
     * @param id el ID de la transacción
     * @return un Optional que contiene la transacción si se encuentra, o vacío
     */
    public Optional<Transaccion> obtenerTransaccionPorId(Long id) {
        try {
            return transaccionDAO.obtenerPorId(id);
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores, puedes mejorar esto
            return Optional.empty(); // Retorna vacío si ocurre un error
        }
    }

    /**
     * Elimina una transacción basada en su ID.
     * @param id el ID de la transacción a eliminar
     */
    public void eliminarTransaccion(Long id) {
        try {
            transaccionDAO.eliminar(id);
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores, puedes mejorar esto
        }
    }
}