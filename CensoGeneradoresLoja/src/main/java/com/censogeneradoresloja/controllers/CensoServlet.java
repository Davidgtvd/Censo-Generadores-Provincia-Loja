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
import com.censogeneradoresloja.services.GeneradorService;

import java.io.IOException;

@WebServlet("/censo")
public class CensoServlet extends HttpServlet {

    private final GeneradorService generadorService = new GeneradorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        req.setAttribute("generadores", generadorService.obtenerGeneradores());

        req.getRequestDispatcher("/WEB-INF/views/censo.jsp").forward(req, resp);
    }
}