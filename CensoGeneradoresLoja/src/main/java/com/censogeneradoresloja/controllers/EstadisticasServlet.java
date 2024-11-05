/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.controllers;

/**
 *
 * @author david
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.censogeneradoresloja.services.EstadisticasService;
import com.censogeneradoresloja.dao.GeneradorDAO;
import com.censogeneradoresloja.dao.TransaccionDAO;

import java.io.IOException;

@WebServlet("/estadisticas")
public class EstadisticasServlet extends HttpServlet {

    private final EstadisticasService estadisticasService;

    public EstadisticasServlet() {
        GeneradorDAO generadorDAO = new GeneradorDAO();
        TransaccionDAO transaccionDAO = new TransaccionDAO();
        this.estadisticasService = new EstadisticasService(generadorDAO, transaccionDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("totalGeneradores", estadisticasService.getTotalGeneradores());
        req.setAttribute("capacidadTotal", estadisticasService.getCapacidadTotal());
        req.setAttribute("mayorGenerador", estadisticasService.getMayorGenerador());

        
        req.getRequestDispatcher("/WEB-INF/views/estadisticas.jsp").forward(req, resp);
    }
}