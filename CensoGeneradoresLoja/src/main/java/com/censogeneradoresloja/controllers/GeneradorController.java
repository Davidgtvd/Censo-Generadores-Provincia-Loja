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

public class GeneradorController {
    private final GeneradorDAO generadorDAO;

    public GeneradorController(GeneradorDAO generadorDAO) {
        this.generadorDAO = generadorDAO;
    }

}