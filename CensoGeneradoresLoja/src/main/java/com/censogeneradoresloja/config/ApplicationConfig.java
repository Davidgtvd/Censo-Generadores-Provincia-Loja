/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.config;

/**
 *
 * @author david
 */
import com.censogeneradoresloja.controllers.*;
import com.censogeneradoresloja.dao.*;
import com.censogeneradoresloja.services.*;

public class ApplicationConfig {

    private final GeneradorDAO generadorDAO = new GeneradorDAO();
    private final TransaccionDAO transaccionDAO = new TransaccionDAO();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public TransaccionService transaccionService() {
        return new TransaccionService(transaccionDAO);
    }

    public EstadisticasService estadisticasService() {
        return new EstadisticasService(generadorDAO, transaccionDAO);
    }

    public GeneradorController generadorController() {
        return new GeneradorController(generadorDAO);
    }

    public UsuarioController usuarioController() {
        return new UsuarioController(usuarioDAO);
    }

    public TransaccionController transaccionController() {
        return new TransaccionController(transaccionService());
    }

    public EstadisticasController estadisticasController() {
        return new EstadisticasController(generadorController(), usuarioController(), estadisticasService());
    }
}