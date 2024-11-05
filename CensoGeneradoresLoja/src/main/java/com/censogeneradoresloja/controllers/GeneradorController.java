/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.controllers;

/**
 *
 * @author david
 */
import com.censogeneradoresloja.dao.GeneradorDAO;
import com.censogeneradoresloja.models.Generador;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class GeneradorController {
    private final GeneradorDAO generadorDAO;

    public GeneradorController() {
        this.generadorDAO = new GeneradorDAO();
    }

    /**
     * Obtiene todos los generadores registrados en la base de datos.
     */
    public List<Generador> obtenerTodosGeneradores() throws IOException {
        return generadorDAO.obtenerTodos();
    }

    /**
     * Registra un nuevo generador en la base de datos.
     */
    public void registrarGenerador(Generador generador) throws IOException {
        if (generador != null) {
            generadorDAO.guardar(generador);
        } else {
            throw new IllegalArgumentException("El generador no puede ser nulo");
        }
    }

    /**
     * Alias para registrar un generador, para compatibilidad con otras clases.
     */
    public void agregarGenerador(Generador generador) throws IOException {
        registrarGenerador(generador);
    }

    /**
     * Actualiza la información de un generador existente en la base de datos.
     */
    public void actualizarGenerador(Generador generador) throws IOException {
        if (generador != null && generador.getId() != null) {
            generadorDAO.guardar(generador);
        } else {
            throw new IllegalArgumentException("El generador es inválido o no tiene ID");
        }
    }

    /**
     * Elimina un generador de la base de datos basado en su ID.
     */
    public void eliminarGenerador(Long id) throws IOException {
        if (id != null && id > 0) {
            generadorDAO.eliminar(id);
        } else {
            throw new IllegalArgumentException("El ID del generador es inválido");
        }
    }

    /**
     * Obtiene un generador por su ID.
     * 
     * @param id El ID del generador a buscar.
     * @return Un Optional que contiene el generador si se encuentra, o vacío si no.
     */
    public Optional<Generador> obtenerGeneradorPorId(Long id) throws IOException {
        if (id != null && id > 0) {
            return generadorDAO.obtenerPorId(id);
        } else {
            throw new IllegalArgumentException("El ID del generador es inválido");
        }
    }
}