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
import com.censogeneradoresloja.models.Generador;

import java.util.List;

public class GeneradorService {

    private final GeneradorDAO generadorDAO;

    public GeneradorService(GeneradorDAO generadorDAO) {
        this.generadorDAO = generadorDAO;
    }

    public GeneradorService() {
        this.generadorDAO = new GeneradorDAO();
    }

    public List<Generador> obtenerGeneradores() {
        return generadorDAO.obtenerTodosGeneradores();
    }
}